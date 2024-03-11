package com.example.todo_list.viewmodel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.*
import com.example.todo_list.model.custom_entities.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList


class ItemsViewAdapter(var items: MutableList<Item>) :
    RecyclerView.Adapter<ItemViewHolder>() {

    var overallItemsNumber = ObservableField(0)
    var checkedItemsNumber = ObservableField(0)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        val viewHolder = ItemViewHolder(view)
/*        viewHolder.addCheckboxClickListener(this)
        viewHolder.addDeleteClickListener(this)
        viewHolder.addTextClickListener(this)*/
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        viewHolder.checkbox.isChecked = items[position].isDone
        viewHolder.text.text = items[position].title
        viewHolder.id = items[position].id
    }

    override fun getItemCount() = items.count()

    @SuppressLint("NotifyDataSetChanged")
    fun update() {
        notifyDataSetChanged()
    }
}