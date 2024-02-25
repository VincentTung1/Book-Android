package com.vincent.book_android

import com.vincent.book_android.retrofit.ApiService
import com.vincent.book_android.retrofit.RetrofitManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


@RunWith(JUnit4::class)
class ServiceUniTest {

    lateinit var retrofit: Retrofit
    lateinit var api: ApiService

    @Before
    fun setUp(){
        retrofit = RetrofitManager.getRetrofit()
        api = retrofit.create(ApiService::class.java)
    }

    @Test
    fun testCreateBook(){
        api.addBook("test","desc","aaa","1999")
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        Assert.assertNotNull(response)
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {

                }
            })
    }

    @Test
    fun testSearchBook(){
        api.searchBooks(1,"test","desc","aaa","1999")
            .enqueue(object : Callback<ArrayList<Book>> {
                override fun onResponse(
                    call: Call<ArrayList<Book>>,
                    response: Response<ArrayList<Book>>
                ) {
                    Assert.assertNotNull(response)
                }

                override fun onFailure(call: Call<ArrayList<Book>>, t: Throwable) {

                }
            })
    }

    @Test
    fun testUpdateBook(){
        api.updateBook(1,"test","desc","aaa","1999")
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Assert.assertNotNull(response)
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {

                }
            })
    }

    @Test
    fun testDeleteBook(){
        api.deleteBook(1)
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Assert.assertNotNull(response)
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {

                }
            })
    }
}