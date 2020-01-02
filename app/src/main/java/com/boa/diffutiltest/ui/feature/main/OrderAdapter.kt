package com.boa.diffutiltest.ui.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.boa.diffutiltest.R
import com.boa.diffutiltest.datasource.OrderDiffCallback
import com.boa.diffutiltest.model.Order
import java.util.*

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {
    private val orderList = ArrayList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    fun clear() {
        orderList.clear()
        notifyDataSetChanged()
    }

    fun setData(list: List<Order>, clean: Boolean) {
        val diffCallback = OrderDiffCallback(orderList, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        if (clean) {
            clear()
        }

        orderList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orderList[position]
        holder.tvItemTitle.text = order.detail
        holder.tvItemDescription.text = order.index.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemTitle: TextView = itemView.findViewById(R.id.tvItemTitle)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tvItemDescription)
    }
}