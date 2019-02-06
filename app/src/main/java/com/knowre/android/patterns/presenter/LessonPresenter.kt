package com.knowre.android.patterns.presenter

import android.content.Context
import com.knowre.android.RxServerImpl
import com.knowre.android.dto.LessonType
import com.knowre.android.dto.Problem
import com.knowre.android.patterns.R
import com.knowre.android.patterns.model.AnswerItem
import com.knowre.android.patterns.presenter.base.AbstractPresenter
import com.knowre.android.patterns.presenter.contract.LessonContract
import com.knowre.android.patterns.recyclerview.adapter.contract.AnswerAdapterContract
import com.knowre.android.patterns.util.getLessenTypeText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LessonPresenter : AbstractPresenter<LessonContract.View>(), LessonContract.Presenter {

    override lateinit var mView: LessonContract.View
    override lateinit var adapterModel: AnswerAdapterContract.Model
    override lateinit var adapterView: AnswerAdapterContract.View
    override lateinit var compositeDisposable: CompositeDisposable

    private var lessonNumber = 0
    private var problemNumber = 1
    private var problemCount = 3
    private val problemList = ArrayList<Problem>()

    private var isLoading = false

    override fun detachView() {
        compositeDisposable.clear()
        super.detachView()
    }

    override fun loadLesson(context: Context, lessonType: LessonType, lessonNumber: Int) {

        if (!isLoading) {
            isLoading = true
            compositeDisposable.add(
                    RxServerImpl(context).fetchLessonData(lessonType, lessonNumber)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->

                                //init
                                this.lessonNumber = result.lessonNumber
                                problemNumber = 1
                                problemCount = result.problemCount
                                problemList.clear()

                                //if type is null
                                val lessonTypeText = if(result.lessonType == null) {
                                    context.getString(getLessenTypeText(lessonType))
                                } else {
                                    context.getString(getLessenTypeText(result.lessonType))
                                }

                                //lesson string
                                val lessonTitle = String.format(context.getString(R.string.lesson_title_format),
                                        result.lessonNumber, lessonTypeText, result.lessonName)

                                //set view
                                mView.setLesson(lessonTitle, problemCount)

                                //load first problem
                                loadProblem(context, lessonNumber, problemNumber)

                            }, { error ->
                                //error
                                //error.printStackTrace()
                                isLoading = false
                            })
            )
        }


    }

    override fun checkAnswer(answer: String) {

        val isCorrect = answer == problemList[problemNumber-1].correctAnswer
        val answerItem = AnswerItem(isCorrect, problemNumber)
        adapterModel.addItem(answerItem)
        adapterView.notifyAdapter()

        mView.setAnswer(isCorrect)

    }

    override fun loadNextProblem(context: Context) {

        if (!isLoading) {
            isLoading = true

            if (problemNumber == problemCount) {
                //last
                mView.finishActivity()
                isLoading = false
            } else {
                problemNumber++
                loadProblem(context, lessonNumber, problemNumber)
            }
        }

    }

    private fun loadProblem(context: Context, lessonNumber: Int, problemNumber: Int) {

        compositeDisposable.add(
                RxServerImpl(context).fetchProblem(lessonNumber, problemNumber)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->

                            //check index
                            this.problemNumber = result.problemNumber
                            problemList.add(result)

                            //set view
                            mView.setProblem(result)
                            isLoading = false

                        }, { error ->
                            //error
                            //error.printStackTrace()
                            isLoading = false
                        })
        )

    }
}