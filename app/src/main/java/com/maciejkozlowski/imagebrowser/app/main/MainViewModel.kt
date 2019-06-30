package com.maciejkozlowski.imagebrowser.app.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maciejkozlowski.imagebrowser.api.ApiService
import com.maciejkozlowski.imagebrowser.api.model.Image
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class MainViewModel @Inject constructor(
    private val apiService: ApiService,
    private val imageUrlConverter: ImageUrlConverter
) : ViewModel() {

    val viewStateLiveData = MutableLiveData<MainViewState>()

    fun fetchList(imageWidth: Int) {
        viewStateLiveData.value = MainViewState.Loading
        val disposable = apiService
            .getList()
            .map { convertList(it, imageWidth) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { list -> viewStateLiveData.value = MainViewState.Content(list) }
            )
    }

    private fun convertList(images: List<Image>, imageWidth: Int): List<Image> {
        return images.map { it.copy(url = imageUrlConverter.convertToProperSizeUrl(it.url, imageWidth.toString())) }
    }
}