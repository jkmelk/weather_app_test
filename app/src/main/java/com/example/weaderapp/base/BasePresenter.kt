package com.example.weaderapp.base


open class BasePresenter<V : BaseView> {

    protected var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}