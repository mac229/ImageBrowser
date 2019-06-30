package com.maciejkozlowski.imagebrowser.app.main

import android.os.Bundle
import com.maciejkozlowski.imagebrowser.R
import com.maciejkozlowski.imagebrowser.base.base.BaseActivity
import com.maciejkozlowski.imagebrowser.base.di.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    internal lateinit var factory: ViewModelFactory<MainViewModel>
    private val viewModel by lazy { getViewModel(factory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        viewModel
    }
}
