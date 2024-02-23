package com.vincent.book_android

interface MVPContract {

    interface MVPView{

       fun updateBooks(books: ArrayList<Book>)
    }

    interface MVPPresenter {
        fun init(view: MVPView)

        fun addBook(name: String?,
                des: String?,
                author: String?,
                year: String?)

        fun searchBooks(id: String?,
                       name: String?,
                       des: String?,
                       author: String?,
                       year: String?)
    }
}