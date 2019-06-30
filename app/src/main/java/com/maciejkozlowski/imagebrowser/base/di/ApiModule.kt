package com.maciejkozlowski.imagebrowser.base.di

import com.maciejkozlowski.imagebrowser.api.Communication
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
}