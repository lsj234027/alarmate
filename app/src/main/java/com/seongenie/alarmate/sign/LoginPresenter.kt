package com.seongenie.alarmate.sign

/**
 * Created by lsj23 on 2020-01-01
 */
class LoginPresenter: LoginContract.Presenter {
    override fun googleLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun kakaoLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun naverLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var view: LoginContract.View

    override fun setView(view: LoginContract.View) {
        this.view = view
    }
}