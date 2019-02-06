package com.knowre.android.patterns.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.knowre.android.patterns.databinding.ViewProblemSolvingResultTagBinding
import com.knowre.android.patterns.model.AnswerItem
import com.knowre.android.patterns.recyclerview.adapter.base.BaseAdapter
import com.knowre.android.patterns.recyclerview.adapter.contract.AnswerAdapterContract
import com.knowre.android.patterns.recyclerview.viewholder.AnswerViewHolder
import com.knowre.android.patterns.recyclerview.viewholder.base.BaseViewHolder

class AnswerAdapter(val context: Context) : BaseAdapter<AnswerItem>(),
        AnswerAdapterContract.View,
        AnswerAdapterContract.Model {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AnswerItem> {
        val itemBinding = ViewProblemSolvingResultTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnswerViewHolder(parent.context, itemBinding)
    }
}