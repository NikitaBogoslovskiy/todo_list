package com.example.todo_list

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private val dataSet: MutableList<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView
        val checkbox: CheckBox
        val delete: ImageButton
        init {
            text = view.findViewById(R.id.item_text)
            checkbox = view.findViewById(R.id.item_is_finished)
            delete = view.findViewById(R.id.delete_item_button)
        }
    }

    var overallItemsNumber = ObservableField(0)
    var checkedItemsNumber = ObservableField(0)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        overallItemsNumber.set((overallItemsNumber.get() ?: 0) + 1)
        return ViewHolder(view).apply {
            checkbox.setOnClickListener {
                text.paintFlags = when (checkbox.isChecked) {
                    true -> {
                        checkedItemsNumber.set((checkedItemsNumber.get() ?: 0) + 1)
                        Paint.STRIKE_THRU_TEXT_FLAG
                    }
                    false -> {
                        checkedItemsNumber.set((checkedItemsNumber.get() ?: 0) - 1)
                        0
                    }
                }
            }
            delete.setOnClickListener {
                overallItemsNumber.set((overallItemsNumber.get() ?: 0) - 1)
                if (checkbox.isChecked) {
                    checkedItemsNumber.set((checkedItemsNumber.get() ?: 0) - 1)
                }
                dataSet.removeAt(this.adapterPosition)
                notifyItemRemoved(this.adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.text.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}