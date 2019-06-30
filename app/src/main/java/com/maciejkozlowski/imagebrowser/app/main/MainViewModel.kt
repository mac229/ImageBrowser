package com.maciejkozlowski.imagebrowser.app.main

import androidx.lifecycle.ViewModel
import com.maciejkozlowski.imagebrowser.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class MainViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    init {
        apiService.getList().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe()
    }

}