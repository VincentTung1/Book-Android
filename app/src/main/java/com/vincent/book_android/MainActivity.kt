package com.vincent.book_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.vincent.book_android.impl.MVPPresenterImpl
import com.vincent.book_android.view.DataAdapter

class MainActivity : AppCompatActivity(),MVPContract.MVPView {

    lateinit var presenter : MVPContract.MVPPresenter

    lateinit var etId: EditText
    lateinit var etName : EditText
    lateinit var etDesc : EditText
    lateinit var etAuthor : EditText
    lateinit var etYear : EditText
    lateinit var rv: RecyclerView
    lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        presenter = MVPPresenterImpl()
        presenter.init(this)
    }

    private fun initViews() {
        etId = findViewById(R.id.name)
        etName = findViewById(R.id.name)
        etDesc = findViewById(R.id.desc)
        etAuthor = findViewById(R.id.author)
        etYear = findViewById(R.id.year)

        rv = findViewById(R.id.rv)
        adapter = DataAdapter(this,null)
        rv.adapter = adapter
    }

    override fun updateBooks(books : ArrayList<Book>) {
        adapter.updateList(books)
    }

    fun add(view: View) {
        presenter.addBook(
            etName.text.toString(),
            etDesc.text.toString(),
            etAuthor.text.toString(),
            etYear.text.toString())
    }

    fun search(view: View){
        presenter.searchBooks(
            etId.text.toString(),
            etName.text.toString(),
            etDesc.text.toString(),
            etAuthor.text.toString(),
            etYear.text.toString())
    }

}