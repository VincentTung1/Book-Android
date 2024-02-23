package com.vincent.book_android.impl

import com.vincent.book_android.Book
import com.vincent.book_android.MVPContract

class MVPPresenterImpl :  MVPContract.MVPPresenter{

    lateinit var view : MVPContract.MVPView

    override fun init(view: MVPContract.MVPView) {
        this.view = view
    }

    override fun addBook(name: String?, des: String?, author: String?, year: String?) {

    }

    override fun searchBooks(
        id: String?,
        name: String?,
        des: String?,
        author: String?,
        year: String?
    ) {
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