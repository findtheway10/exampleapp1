package com.knowre.android.patterns.presenter

import android.content.Context
import com.knowre.android.RxServerImpl
import com.knowre.android.patterns.presenter.base.AbstractPresenter
import com.knowre.android.patterns.presenter.contract.LessonContract
import com.knowre.android.patterns.util.TEST_LESSON_NUMBER
import com.knowre.android.patterns.util.TEST_LESSON_TYPE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LessonPresenter : AbstractPresenter<LessonContract.View>(), LessonContract.Presenter {

    override lateinit var mView: LessonContract.View
    //override lateinit var adapterModel: WeatherAdapterContract.Model
    //override lateinit var adapterView: WeatherAdapterContract.View
    override lateinit var compositeDisposable: CompositeDisposable

    override fun detachView() {
        compositeDisposable.clear()
        super.detachView()
    }

    override fun loadLesson(context: Context) {

        compositeDisposable.add(
                RxServerImpl(context).fetchLessonData(TEST_LESSON_TYPE, TEST_LESSON_NUMBER)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            mView.setLesson(result)
                        }, { error ->
                            //error
                            //error.printStackTrace()
                        })
        )

    }

}