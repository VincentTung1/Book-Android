package com.vincent.book_android.impl

import com.vincent.book_android.Book
import com.vincent.book_android.MVPContract
import com.vincent.book_android.retrofit.ApiService
import com.vincent.book_android.retrofit.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MVPPresenterImpl :  MVPContract.MVPPresenter{

    lateinit var view : MVPContract.MVPView

    lateinit var retrofit: Retrofit
    lateinit var api: ApiService

    override fun init(view: MVPContract.MVPView) {
        this.view = view
        retrofit = RetrofitManager.getRetrofit()
        api = retrofit.create(ApiService::class.java)
    }

    override fun addBook(name: String?, desc: String?, author: String?, year: String?) {
        api.addBook(name, desc,author,year)
    }

    override fun searchBooks(
        id: String?,
        name: String?,
        desc: String?,
        author: String?,
        year: String?
    ) {

        // API:
//        api.searchBooks(id,name,desc,author,year).enqueue(object : Callback<ArrayList<Book>>{
//            override fun onResponse(
//                call: Call<ArrayList<Book>>,
//                response: Response<ArrayList<Book>>
//            ) {
//                view.updateBooks(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<ArrayList<Book>>, t: Throwable) {
//
//            }
//        })

        // same with the "Add Book API, but this is only for the UI display to see the ui if it work."
        view.updateBooks(
            arrayListOf(Book(
                "idXXX",
                  "test",
                 "abcde",
                   "Happy",
                "1999"
            ))
        )
    }

}