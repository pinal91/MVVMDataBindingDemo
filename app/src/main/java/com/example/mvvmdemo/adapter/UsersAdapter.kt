package com.example.mvvmdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.model.User

import androidx.databinding.DataBindingUtil
import com.example.mvvmdemo.databinding.UserRowBinding
import androidx.annotation.NonNull





class UsersAdapter(private val context: Context, private var list: MutableList<User>) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val employeeListItemBinding: UserRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            com.example.mvvmdemo.R.layout.user_row, viewGroup, false
        )
        return MyViewHolder(employeeListItemBinding)

    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(employeeViewHolder: MyViewHolder, i: Int) {
        val currentStudent: User = list.get(i)
        employeeViewHolder.employeeListItemBinding.user=currentStudent
    }

    class MyViewHolder(employeetListItemBinding: UserRowBinding) :
        RecyclerView.ViewHolder(employeetListItemBinding.root) {
        val employeeListItemBinding: UserRowBinding = employeetListItemBinding

    }


}