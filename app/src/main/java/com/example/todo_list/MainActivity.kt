package com.example.todo_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.todo_list.databinding.ActivityMainBinding
import com.example.todo_list.databinding.FragmentItemDetailsBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment, ItemsList()).commit()
    }
}