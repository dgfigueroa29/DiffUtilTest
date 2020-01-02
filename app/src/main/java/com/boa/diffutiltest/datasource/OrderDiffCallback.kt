package com.boa.diffutiltest.datasource

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.boa.diffutiltest.model.Order

class OrderDiffCallback(private val oldList: List<Order>, private val newList: List<Order>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].index === newList.get(newItemPosition).index
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val (_, detail) = oldList[oldPosition]
        val (_, detail1) = newList[newPosition]

        return detail == detail1
    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}