package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.FragmentItemsListBinding

data class ItemInfo(var title: String, var date: String, var time: String, var details: String)

class ItemsList : Fragment() {
    private lateinit var binding: FragmentItemsListBinding
    private lateinit var recyclerView: RecyclerView
    private var dataset = mutableListOf(
        ItemInfo(
            "Buy some milk", "4.04.2023", "16:30",
            "Milk should be fresh. Please, don't buy some garbage as usual. I want to live, you know."
        ),
        ItemInfo(
            "Go to bed", "8.04.2023", "22:15",
            "The next day is really important so you need to sleep properly. Don't waste your time and go to bed."
        ),
        ItemInfo(
            "Watch cartoon", "1.04.2023", "7:00",
            "You have to wake up early and watch cartoon... Ha, the joke! The first of April today."
        )
    )
    private var customAdapter = CustomAdapter(dataset)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_items_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = customAdapter
        recyclerView = view.findViewById(R.id.todo_list_viewer)
        recyclerView.adapter = customAdapter

        view.findViewById<Button>(R.id.add_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_itemsList_to_newItem)
        }
    }
}