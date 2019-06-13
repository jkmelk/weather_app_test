package com.example.weaderapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weaderapp.R

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), BaseView {

    protected abstract var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}
