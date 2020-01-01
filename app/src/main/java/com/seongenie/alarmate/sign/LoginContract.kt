package com.seongenie.alarmate.sign

/**
 * Created by lsj23 on 2020-01-01
 */
interface LoginContract {
    interface View {
        fun updateUI()
    }
    interface Presenter {
        fun setView(view: View)
        fun googleLogin()
        fun kakaoLogin()
        fun naverLogin()
    }
}