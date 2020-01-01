package com.seongenie.alarmate.sign

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.kakao.auth.*
import com.seongenie.alarmate.R
import com.seongenie.alarmate.Toolkit
import com.seongenie.alarmate.sign.kakao.GlobalApplication
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by lsj23 on 2020-01-01
 */

class LoginActivity : Activity(), LoginContract.View, Toolkit {
    private lateinit var presenter: LoginContract.Presenter
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initLoginButton()

    }

    private fun initLoginButton() {
        btn_google_login + {
            presenter = LoginPresenter().apply { setView(this@LoginActivity) }

            // Configure Google Sign In
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            googleSignInClient = GoogleSignIn.getClient(this, gso)

            var RC_SIGN_IN = 0
            startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)
        }

        btn_naver_login + { presenter.naverLogin() }
//        btn_kakao_login + {  }

    }

    override fun onStart() {
        super.onStart()
        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(this)
        if(account != null) {
            updateUI(account)
        }
    }

    override fun updateUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun updateUI(account: GoogleSignInAccount) {
        Log.i("login", "${account.displayName}: ${account.email}")
    }

}