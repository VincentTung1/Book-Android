package com.vincent.book_android.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    fun getRetrofit() : Retrofit {
       return Retrofit.Builder()
            .baseUrl("http://127.0.0.1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}