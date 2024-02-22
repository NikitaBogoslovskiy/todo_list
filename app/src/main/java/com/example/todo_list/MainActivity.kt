package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = mutableListOf("Buy some milk", "Do homework", "Help parents with cooking")
        val customAdapter = CustomAdapter(dataset)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.adapter = customAdapter
        val recyclerView: RecyclerView = findViewById(R.id.todo_list_viewer)
        recyclerView.adapter = customAdapter
    }
}