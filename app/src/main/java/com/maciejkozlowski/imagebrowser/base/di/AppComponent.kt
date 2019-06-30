package com.maciejkozlowski.imagebrowser.base.di

import com.maciejkozlowski.imagebrowser.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    BuildersModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>

}