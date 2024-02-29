package com.example.todo_list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.todo_list.R
import com.example.todo_list.viewmodel.Item


class NewItem : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener {
            it.findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            val newItem = Item(
                0,
                false,
                view.findViewById<TextView>(R.id.item_title).text.toString(),
                view.findViewById<TextView>(R.id.item_date).text.toString(),
                view.findViewById<TextView>(R.id.item_time).text.toString(),
                view.findViewById<TextView>(R.id.item_details).text.toString()
            )
            Dependencies.viewModel.insertNew(newItem)
            it.findNavController().navigateUp()
        }
    }
}