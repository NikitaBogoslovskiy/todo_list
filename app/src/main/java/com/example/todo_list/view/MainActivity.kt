package com.example.todo_list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_list.R
import com.example.todo_list.viewmodel.ItemsViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        ItemsList()
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.nav_host_fragment, ItemsList()
        ).commit()
    }
}