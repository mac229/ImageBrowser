package com.maciejkozlowski.imagebrowser

import com.maciejkozlowski.imagebrowser.base.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}