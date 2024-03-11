package com.example.todo_list.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.todo_list.Dependencies
import com.example.todo_list.R

const val ARG_TITLE = "title"
const val ARG_DATE = "date"
const val ARG_TIME = "time"
const val ARG_DETAILS = "details"


class ItemDetails : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val item = Dependencies.itemsAppViewModel.get(it.getLong("id"))
            view.findViewById<TextView>(R.id.item_title).text = item?.title
            view.findViewById<TextView>(R.id.item_date).text = item?.date
            view.findViewById<TextView>(R.id.item_time).text = item?.time
            view.findViewById<TextView>(R.id.item_details).text = item?.details
        }
        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}