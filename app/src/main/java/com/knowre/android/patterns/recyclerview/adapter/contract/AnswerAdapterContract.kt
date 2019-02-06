package com.knowre.android.patterns.recyclerview.adapter.contract

import com.knowre.android.patterns.model.AnswerItem
import com.knowre.android.patterns.recyclerview.adapter.base.BaseAdapterContract

interface AnswerAdapterContract: BaseAdapterContract {

    interface View: BaseAdapterContract.View

    interface Model: BaseAdapterContract.Model<AnswerItem>
}