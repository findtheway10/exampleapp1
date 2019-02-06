package com.knowre.android.patterns.recyclerview.viewholder

import android.content.Context
import com.knowre.android.patterns.databinding.ViewProblemSolvingResultTagBinding
import com.knowre.android.patterns.model.AnswerItem
import com.knowre.android.patterns.recyclerview.viewholder.base.BaseViewHolder

class AnswerViewHolder(
        private val mContext: Context,
        private val binding: ViewProblemSolvingResultTagBinding
) : BaseViewHolder<AnswerItem>(binding.root) {

    override fun onBindView(item: AnswerItem, position: Int) {
        binding.answer = item
        binding.executePendingBindings()
    }

}