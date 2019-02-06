package com.knowre.android.patterns.presenter.contract

import android.content.Context
import com.knowre.android.dto.LessonType
import com.knowre.android.dto.Problem
import com.knowre.android.patterns.presenter.base.BasePresenter
import com.knowre.android.patterns.presenter.base.BaseView
import com.knowre.android.patterns.recyclerview.adapter.contract.AnswerAdapterContract
import io.reactivex.disposables.CompositeDisposable

interface LessonContract {

    interface View : BaseView {

        fun setLesson(lessonString: String, problemCount: Int)
        fun setProblem(problem: Problem)
        fun setAnswer(isCorrect: Boolean)
        fun finishActivity()
    }

    interface Presenter: BasePresenter<View> {

        var mView: View
        var adapterModel: AnswerAdapterContract.Model
        var adapterView: AnswerAdapterContract.View
        var compositeDisposable: CompositeDisposable

        fun loadLesson(context: Context, lessonType: LessonType, lessonNumber: Int)
        fun loadNextProblem(context: Context)
        fun checkAnswer(answer: String)
    }
}