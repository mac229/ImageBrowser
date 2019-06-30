package com.maciejkozlowski.imagebrowser.base.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.maciejkozlowski.imagebrowser.base.di.ViewModelFactory

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
abstract class BaseActivity : AppCompatActivity() {

    inline fun <reified T : ViewModel> getViewModel(factory: ViewModelFactory<T>): T {
        return ViewModelProviders.of(this, factory)[T::class.java]
    }

    fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe(this@BaseActivity, Observer(action))
    }
}