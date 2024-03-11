package com.example.todo_list.viewmodel.adapter

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.Dependencies
import com.example.todo_list.R

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val text: TextView
    val checkbox: CheckBox
    private val delete: ImageButton
    var id: Long = 0
    init {
        text = view.findViewById(R.id.item_text)
        checkbox = view.findViewById(R.id.item_is_finished)
        delete = view.findViewById(R.id.delete_item_button)
    }

    fun addCheckboxClickListener(adapter: ItemsViewAdapter) {
        checkbox.setOnClickListener {
            Dependencies.itemsAppViewModel.changeStatus(id, checkbox.isChecked)
            adapter.notifyItemChanged(adapterPosition)
        }
    }

    fun addDeleteClickListener(adapter: ItemsViewAdapter) {
        delete.setOnClickListener {
            Dependencies.itemsAppViewModel.delete(id)
            adapter.notifyItemRemoved(adapterPosition)
        }
    }

    fun addTextClickListener() {
        text.setOnClickListener {
            val args = Bundle()
            args.putLong("id", id)
            it.findNavController().navigate(R.id.action_itemsList_to_itemDetails, args)
        }
    }
}