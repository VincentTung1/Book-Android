package com.vincent.book_android

interface MVPContract {

    interface MVPView{

       fun updateBooks(books: ArrayList<Book>)

       fun toastSuccess()

       fun toastFailed()
    }

    interface MVPPresenter {
        fun init(view: MVPView)

        fun addBook(name: String?,
                    desc: String?,
                    author: String?,
                    year: String?)

        fun searchBooks(bid: Int?,
                       name: String?,
                       des: String?,
                       author: String?,
                       year: String?)

        fun updateBook(bid: Int?,
                       name: String?,
                       desc: String?,
                       author: String?,
                       year: String?)

        fun deleteBook(bid: Int?)
    }
}