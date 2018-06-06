package com.example.android.codelabs.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @data  2018/6/6.
 * @author syb
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        adaptResource()
        initView()
    }

    private fun adaptResource() {
        DensityHelper.setCustomDensity(this, this.application)
    }

    abstract fun initView()

    abstract fun getLayoutResId(): Int

}