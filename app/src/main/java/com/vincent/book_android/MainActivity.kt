package com.vincent.book_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
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

    override fun toastSuccess() {
        Toast.makeText(this,"success!",Toast.LENGTH_SHORT).show()
    }

    override fun toastFailed() {
        Toast.makeText(this,"failed!",Toast.LENGTH_SHORT).show()
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
            if (etId.text.isEmpty()) -1 else etId.text.toString().toInt(),
            etName.text.toString(),
            etDesc.text.toString(),
            etAuthor.text.toString(),
            etYear.text.toString())
    }

    fun update(view: View) {
        presenter.updateBook(if (etId.text.isEmpty()) -1 else etId.text.toString().toInt(),
            etName.text.toString(),
            etDesc.text.toString(),
            etAuthor.text.toString(),
            etYear.text.toString())
    }
    fun delete(view: View) {
        presenter.deleteBook(if (etId.text.isEmpty()) -1 else etId.text.toString().toInt())
    }

}