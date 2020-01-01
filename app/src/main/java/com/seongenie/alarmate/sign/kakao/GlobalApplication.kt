package com.seongenie.alarmate.sign.kakao

import android.app.Application
import android.content.Context
import com.kakao.auth.*

/**
 * Created by lsj23 on 2020-01-01
 */
class GlobalApplication: Application() {
    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: GlobalApplication
    }

    override fun onCreate() {
        super.onCreate()
        KakaoSDK.init(KakaoSDKAdapter())
    }

    class KakaoSDKAdapter: KakaoAdapter() {
        override fun getSessionConfig(): ISessionConfig {
            return object : ISessionConfig {
                override fun isSaveFormData() = true
                override fun isSecureMode() = false
                override fun getApprovalType() = ApprovalType.INDIVIDUAL
                override fun isUsingWebviewTimer() = false
                override fun getAuthTypes() = arrayOf(AuthType.KAKAO_TALK)
            }
        }
        override fun getApplicationConfig() = IApplicationConfig { INSTANCE.applicationContext }
    }
}

