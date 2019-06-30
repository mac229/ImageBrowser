package com.maciejkozlowski.imagebrowser.base.di

import com.maciejkozlowski.imagebrowser.api.Communication
import com.maciejkozlowski.imagebrowser.base.rx.DefaultSchedulersProvider
import com.maciejkozlowski.imagebrowser.base.rx.SchedulersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

@Module
object ApiModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiService() = Communication().apiService

    @JvmStatic
    @Singleton
    @Provides
    fun provideSchedulersProvider(): SchedulersProvider = DefaultSchedulersProvider()
}