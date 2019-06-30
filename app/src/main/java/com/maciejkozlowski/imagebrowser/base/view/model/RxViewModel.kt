package com.maciejkozlowski.imagebrowser.base.view.model

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
abstract class RxViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.addToCompositeDisposable() {
        compositeDisposable.addAll(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}