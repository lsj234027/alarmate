package com.seongenie.alarmate

import android.view.View

/**
 * Created by lsj23 on 2020-01-01
 */
interface Toolkit {
    operator fun View.plus(event: () -> Unit) { setOnClickListener { event() } }

}