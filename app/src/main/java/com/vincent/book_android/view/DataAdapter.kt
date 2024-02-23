package com.vincent.book_android.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vincent.book_android.Book
import com.vincent.book_android.R

class DataAdapter(val context: Context,var books : ArrayList<Book>?) : RecyclerView.Adapter<DataAdapter.ItemHolder>() {

    class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.name)
        val tvDesc = view.findViewById<TextView>(R.id.desc)
        val tvAuthor = view.findViewById<TextView>(R.id.author)
        val tvYear = view.findViewById<TextView>(R.id.year)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       val inflater = LayoutInflater.from(context).inflate(R.layout.item_rv,parent,false)
        return ItemHolder(inflater)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        books?.apply {
            val item = books!![position]
            holder.tvName.text = item.name
            holder.tvDesc.text = item.desc
            holder.tvAuthor.text = item.author
            holder.tvYear.text = item.year
        }
    }

    override fun getItemCount(): Int {
        if(books == null) return 0
        return books!!.size
    }

    fun updateList(books: ArrayList<Book>){
        this.books?.clear()
        this.books = books
        notifyDataSetChanged()
    }
}