package com.example.todo_list.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.todo_list.Dependencies
import com.example.todo_list.R
import com.example.todo_list.model.custom_entities.Item


class ItemNewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener {
            it.findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            val title = view.findViewById<TextView>(R.id.item_title).text.toString()
            val date = view.findViewById<TextView>(R.id.item_date).text.toString()
            val time = view.findViewById<TextView>(R.id.item_time).text.toString()
            val details = view.findViewById<TextView>(R.id.item_details).text.toString()
            val item = Item(0, false, title, date, time, details)
            Dependencies.appViewModel.insert(item)
            it.findNavController().navigateUp()
        }
    }
}