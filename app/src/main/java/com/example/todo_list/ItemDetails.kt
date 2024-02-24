package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        // Inflate the layout for this fragment
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
    }

/*    companion object {
        *//**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemDetails.
         *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemDetails().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}