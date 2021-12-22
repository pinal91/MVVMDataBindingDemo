package com.example.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.R
import com.example.mvvmdemo.adapter.UsersAdapter
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.model.User
import com.example.mvvmdemo.viewmodelproviderfactories.UserViewModelFactory
import com.example.mvvmdemo.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var listUsers: MutableList<User>
    private lateinit var adapter: UsersAdapter
    private lateinit var binding:ActivityMainBinding
    lateinit var mainActivityViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerMain    .layoutManager = LinearLayoutManager(this@MainActivity)
        listUsers = mutableListOf<User>()
        adapter= UsersAdapter(this,listUsers)
        binding.recyclerMain.adapter=adapter

        // mainActivityViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        mainActivityViewModel=ViewModelProviders.of(this,UserViewModelFactory(this)).get(UserViewModel::class.java)
        mainActivityViewModel.getData().observe(this,
            { t ->
                listUsers.clear()
                t?.let {
                    listUsers.addAll(it)
                }
                adapter.notifyDataSetChanged()
            })
    }
}