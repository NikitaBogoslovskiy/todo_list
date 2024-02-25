package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController

const val ARG_TITLE = "title"
const val ARG_DATE = "date"
const val ARG_TIME = "time"
const val ARG_DETAILS = "details"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
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
            view.findViewById<TextView>(R.id.item_title).text = it.getString(ARG_TITLE)
            view.findViewById<TextView>(R.id.item_date).text = it.getString(ARG_DATE)
            view.findViewById<TextView>(R.id.item_time).text = it.getString(ARG_TIME)
            view.findViewById<TextView>(R.id.item_details).text = it.getString(ARG_DETAILS)
        }
        view.findViewById<ImageButton>(R.id.back_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_itemDetails_to_itemsList)
        }
    }
}