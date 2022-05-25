package com.marcoguerrera.marcomovies.ui

import android.os.Bundle
import com.marcoguerrera.marcomovies.R
import com.marcoguerrera.marcomovies.common.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}