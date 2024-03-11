package com.example.todo_list

import android.graphics.Paint
import com.example.todo_list.model.custom_entities.Item
import com.example.todo_list.model.database.ItemEntity

class Utils {
    companion object {
        @JvmStatic
        fun getTextStyle(isCrossed: Boolean): Int {
            return if (isCrossed)
                Paint.STRIKE_THRU_TEXT_FLAG
            else
                0
        }
    }
}