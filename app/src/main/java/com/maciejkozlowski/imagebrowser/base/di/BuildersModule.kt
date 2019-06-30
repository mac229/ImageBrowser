package com.maciejkozlowski.imagebrowser.base.di

import com.maciejkozlowski.imagebrowser.app.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

@Suppress("unused")
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}