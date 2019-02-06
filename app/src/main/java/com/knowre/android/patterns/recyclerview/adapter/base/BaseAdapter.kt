package com.knowre.android.patterns.recyclerview.adapter.base

import android.support.v7.widget.RecyclerView
import com.knowre.android.patterns.recyclerview.viewholder.base.BaseViewHolder
import java.util.*

abstract class BaseAdapter<ITEM> : RecyclerView.Adapter<BaseViewHolder<ITEM>>(),
        BaseAdapterContract.View,
        BaseAdapterContract.Model<ITEM> {

    protected var itemList: ArrayList<ITEM> = ArrayList()

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        itemList[position].let {
            holder.onBindView(it, position)
        }
    }

    override fun getItemCount() = itemList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(itemList: ArrayList<ITEM>) {
        this.itemList.addAll(itemList)
    }

    override fun clearItem() {
        itemList.clear()
    }

    override fun getItem(position: Int): ITEM = itemList[position]

    override fun setItem(position: Int, item: ITEM) {
        itemList[position] = item
    }

    override fun removeItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun addItem(item: ITEM) {
        itemList.add(item)
    }

    override fun addItem(index: Int, item: ITEM) {
        itemList.add(index, item)
    }
}