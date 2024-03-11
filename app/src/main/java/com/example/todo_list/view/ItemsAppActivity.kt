package com.example.todo_list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_list.Dependencies
import com.example.todo_list.R


class ItemsAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_app)
    }
}