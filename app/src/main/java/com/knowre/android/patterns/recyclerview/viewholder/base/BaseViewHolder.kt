package com.knowre.android.patterns.recyclerview.viewholder.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in ITEM>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBindView(item: ITEM, position: Int)


}