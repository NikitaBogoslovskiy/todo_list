package com.example.todo_list.viewmodel.adapter

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
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
/*        checkbox.setOnClickListener {
            Dependencies.viewModel.changeStatusById(id, checkbox.isChecked)
            text.paintFlags = when (checkbox.isChecked) {
                true -> {
                    adapter.checkedItemsNumber.set((adapter.checkedItemsNumber.get() ?: 0) + 1)
                    Paint.STRIKE_THRU_TEXT_FLAG
                }
                false -> {
                    adapter.checkedItemsNumber.set((adapter.checkedItemsNumber.get() ?: 0) - 1)
                    0
                }
            }
        }*/
    }

    fun addDeleteClickListener(adapter: ItemsViewAdapter) {
/*        delete.setOnClickListener {
            Dependencies.viewModel.deleteById(id)
            adapter.overallItemsNumber.set((adapter.overallItemsNumber.get() ?: 0) - 1)
            if (checkbox.isChecked) {
                adapter.checkedItemsNumber.set((adapter.checkedItemsNumber.get() ?: 0) - 1)
            }
            adapter.items.removeAt(adapterPosition)
            adapter.notifyItemRemoved(adapterPosition)
        }*/
    }

    fun addTextClickListener(adapter: ItemsViewAdapter) {
/*        text.setOnClickListener {
            val args = Bundle()
            args.putLong("id", id)
            it.findNavController().navigate(R.id.action_itemsList_to_itemDetails, args)
        }*/
    }
}