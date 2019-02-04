package com.knowre.android.patterns.presenter.contract

import android.content.Context
import com.knowre.android.dto.LessonData
import com.knowre.android.patterns.presenter.base.BasePresenter
import com.knowre.android.patterns.presenter.base.BaseView
import io.reactivex.disposables.CompositeDisposable

interface LessonContract {

    interface View : BaseView {

        fun setLesson(lessonData: LessonData)
//        fun finishProgress()
//        fun failConnection()
    }

    interface Presenter: BasePresenter<View> {

        var mView: View
        //var adapterModel: WeatherAdapterContract.Model
        //var adapterView: WeatherAdapterContract.View
        var compositeDisposable: CompositeDisposable

        fun loadLesson(context: Context)

    }
}