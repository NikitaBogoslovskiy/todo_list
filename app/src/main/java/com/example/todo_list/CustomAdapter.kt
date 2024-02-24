package com.example.todo_list

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView


interface ItemListener {
    fun onItemClick()
}

class CustomAdapter(private val dataSet: MutableList<String>,
                    private val listener: ItemListener) :
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

    lateinit var manager: FragmentManager
    lateinit var navController: NavController
    var overallItemsNumber = ObservableField(dataSet.size)
    var checkedItemsNumber = ObservableField(0)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
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

            itemView.setOnClickListener {
                listener.onItemClick()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.text.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}