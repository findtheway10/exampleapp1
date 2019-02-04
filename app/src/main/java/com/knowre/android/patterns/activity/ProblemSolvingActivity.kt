package com.knowre.android.patterns.activity

import android.os.Bundle
import com.knowre.android.dto.LessonData
import com.knowre.android.patterns.R
import com.knowre.android.patterns.activity.base.BaseActivity
import com.knowre.android.patterns.presenter.LessonPresenter
import com.knowre.android.patterns.presenter.contract.LessonContract
import com.knowre.android.patterns.util.getLessenTypeText
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_problem_solving.*

class ProblemSolvingActivity : BaseActivity(), LessonContract.View {

    private lateinit var presenter: LessonPresenter
    //private lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_solving)

        presenter = LessonPresenter().apply {
            mView = this@ProblemSolvingActivity
            compositeDisposable = CompositeDisposable()
        }

        presenter.loadLesson(this@ProblemSolvingActivity)

    }

    override fun setLesson(lessonData: LessonData) {

        problem_solving_progress.max = lessonData.problemCount
        lesson_title.text = String.format(getString(R.string.lesson_title_format),
                lessonData.lessonNumber, getString(getLessenTypeText(lessonData.lessonType)), lessonData.lessonName)

    }

}