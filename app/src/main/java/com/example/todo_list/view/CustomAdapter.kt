package com.example.todo_list.view

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.*
import com.example.todo_list.viewmodel.Item


class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val text: TextView
    val checkbox: CheckBox
    private val delete: ImageButton
    var id: Long = 0
    init {
        text = view.findViewById(R.id.item_text)
        checkbox = view.findViewById(R.id.item_is_finished)
        delete = view.findViewById(R.id.delete_item_button)
    }

    fun addCheckboxClickListener(adapter: CustomAdapter) {
        checkbox.setOnClickListener {
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
        }
    }

    fun addDeleteClickListener(adapter: CustomAdapter) {
        delete.setOnClickListener {
            Dependencies.viewModel.deleteById(id)
            adapter.overallItemsNumber.set((adapter.overallItemsNumber.get() ?: 0) - 1)
            if (checkbox.isChecked) {
                adapter.checkedItemsNumber.set((adapter.checkedItemsNumber.get() ?: 0) - 1)
            }
            adapter.items.removeAt(adapterPosition)
            adapter.notifyItemRemoved(adapterPosition)
        }
    }

    fun addTextClickListener(adapter: CustomAdapter) {
        text.setOnClickListener {
            val args = Bundle()
            args.putLong("id", id)
            it.findNavController().navigate(R.id.action_itemsList_to_itemDetails, args)
        }
    }
}

class CustomAdapter(val items: MutableList<Item>) :
    RecyclerView.Adapter<ViewHolder>() {

    var overallItemsNumber = ObservableField(items.size)
    var checkedItemsNumber = ObservableField(items.filter { it.isDone }.size)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        val viewHolder = ViewHolder(view)
        viewHolder.addCheckboxClickListener(this)
        viewHolder.addDeleteClickListener(this)
        viewHolder.addTextClickListener(this)
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.checkbox.isChecked = items[position].isDone
        viewHolder.text.text = items[position].title
        viewHolder.id = items[position].id
    }

    override fun getItemCount() = items.size
}