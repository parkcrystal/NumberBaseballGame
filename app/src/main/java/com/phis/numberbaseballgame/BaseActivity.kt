package com.phis.numberbaseballgame

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    abstract fun setupEvents()

    abstract fun setValues()

}