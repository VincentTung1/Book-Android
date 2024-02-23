package com.vincent.book_android.retrofit

import com.vincent.book_android.Book
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.Objects

interface ApiService {

    @FormUrlEncoded
    @POST("/book/book-insert")
    fun addBook(@Field("name") name: String?,
                       @Field("desc") desc: String?,
                       @Field("author") author: String?,
                       @Field("year") year: String?): Call<Any>

    @POST("/book")
    fun searchBooks(
                @Field("id") id: String?,
                @Field("name") name: String?,
                @Field("desc") desc: String?,
                @Field("author") author: String?,
                @Field("year") year: String?) : Call<ArrayList<Book>>
}