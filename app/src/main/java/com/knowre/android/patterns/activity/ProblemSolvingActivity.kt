package com.knowre.android.patterns.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.knowre.android.dto.Problem
import com.knowre.android.patterns.activity.base.BaseActivity
import com.knowre.android.patterns.presenter.LessonPresenter
import com.knowre.android.patterns.presenter.contract.LessonContract
import com.knowre.android.patterns.recyclerview.adapter.AnswerAdapter
import com.knowre.android.patterns.util.TEST_LESSON_NUMBER
import com.knowre.android.patterns.util.TEST_LESSON_TYPE
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_problem_solving.*


class ProblemSolvingActivity : BaseActivity(), LessonContract.View {

    private lateinit var presenter: LessonPresenter
    private lateinit var adapter: AnswerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.knowre.android.patterns.R.layout.activity_problem_solving)

        initView()
        presenter = LessonPresenter().apply {
            mView = this@ProblemSolvingActivity
            adapterModel = adapter
            adapterView = adapter
            compositeDisposable = CompositeDisposable()
        }

        presenter.loadLesson(this@ProblemSolvingActivity, TEST_LESSON_TYPE, TEST_LESSON_NUMBER)

    }

    private fun initView() {

        adapter = AnswerAdapter(this@ProblemSolvingActivity)
        problem_solving_result_tag_recycler_view.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(
                this@ProblemSolvingActivity, LinearLayoutManager.HORIZONTAL, false)

        problem_solving_result_tag_recycler_view.layoutManager = linearLayoutManager

        answer_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                isUsingAnswerButton(s.isNotEmpty())
            }
        })

        //keyboard enter key event
//        answer_input.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
//            when (actionId) {
//                EditorInfo.IME_ACTION_DONE -> {
//                    presenter.checkAnswer(answer_input.text.toString())
//                }
//                else ->
//                    return@OnEditorActionListener false
//            }
//            true
//        })

        check_answer.setOnClickListener {
            presenter.checkAnswer(answer_input.text.toString())
        }

        proceed_next.setOnClickListener {
            presenter.loadNextProblem(this@ProblemSolvingActivity)
        }

    }

    override fun setLesson(lessonString: String, problemCount: Int) {

        //init
        problem_solving_progress.max = problemCount
        problem_solving_progress.progress = 1
        answer_input.isEnabled = true

        //set text
        lesson_title.text = lessonString
    }

    override fun setProblem(problem: Problem) {

        //view setting
        symbol_problem_answer_result.visibility = View.GONE
        check_answer.visibility = View.VISIBLE
        proceed_next.visibility = View.GONE
        answer_input.text.clear()
        answer_input.isEnabled = true

        //set text
        problem_number_box.text = problem.problemNumber.toString()
        problem_content.text = problem.problemContent

        //setProgress
        problem_solving_progress.progress = problem.problemNumber
        //check last
        if (problem_solving_progress.max == problem.problemNumber) {
            proceed_next.text = getString(com.knowre.android.patterns.R.string.lesson_complete)
        }
    }

    override fun setAnswer(isCorrect: Boolean) {
        //view setting
        symbol_problem_answer_result.visibility = View.VISIBLE
        check_answer.visibility = View.GONE
        proceed_next.visibility = View.VISIBLE
        answer_input.isEnabled = false

        //set image
        if (isCorrect) {
            symbol_problem_answer_result.setImageResource(com.knowre.android.patterns.R.drawable.problem_correct)
        } else {
            symbol_problem_answer_result.setImageResource(com.knowre.android.patterns.R.drawable.problem_incorrect)
        }
    }

    override fun finishActivity() {
        finish()
    }

    private fun isUsingAnswerButton(isUsing: Boolean) {
        if (isUsing) {
            check_answer.setBackgroundColor(ContextCompat.getColor(this@ProblemSolvingActivity, com.knowre.android.patterns.R.color._38D579))
            check_answer.setTextColor(ContextCompat.getColor(this@ProblemSolvingActivity, com.knowre.android.patterns.R.color._FFFFFF))
            check_answer.isEnabled = true
        } else {
            check_answer.setBackgroundColor(ContextCompat.getColor(this@ProblemSolvingActivity, com.knowre.android.patterns.R.color._EAEAEA))
            check_answer.setTextColor(ContextCompat.getColor(this@ProblemSolvingActivity, com.knowre.android.patterns.R.color._9C9C9C))
            check_answer.isEnabled = false
        }
    }

}