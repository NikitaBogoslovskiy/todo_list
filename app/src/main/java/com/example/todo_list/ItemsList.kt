package com.example.todo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.FragmentItemDetailsBinding
import com.example.todo_list.databinding.FragmentItemsListBinding

class ItemsList : Fragment() {
    private lateinit var binding: FragmentItemsListBinding
    private lateinit var recyclerView: RecyclerView
    private var dataset = mutableListOf("Buy some milk", "Do homework", "Help parents with cooking")
    private val customAdapter = CustomAdapter(dataset, object : ItemListener {
        override fun onItemClick() {
            navigateToFragment()
        }
    })

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
        customAdapter.manager = parentFragmentManager
    }

    private fun navigateToFragment() {
        findNavController().navigate(R.id.action_itemsList_to_itemDetails, null)
    }
}