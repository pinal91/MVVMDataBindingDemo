package com.example.mvvmdemo.api

import com.example.mvvmdemo.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>

}