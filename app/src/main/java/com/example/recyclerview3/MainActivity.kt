package com.example.recyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todoAdapter = TodoAdapter(list)
        todoAdapter.itemClick={
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
        Btn1.setOnClickListener {
            if (NameEdt.editText?.text.isNullOrEmpty()) {
                NameEdt.isErrorEnabled = true
                NameEdt.error = "cannot be empty"
            } else {
                NameEdt.isErrorEnabled = false
                list.add(NameEdt.editText?.text.toString())
                NameEdt.editText?.setText("")
                todoAdapter.notifyDataSetChanged()
            }
        }
        moviesRv.apply {
            layoutManager = GridLayoutManager(this@MainActivity,1,RecyclerView.VERTICAL,false)
            adapter = todoAdapter
        }
    }
}
