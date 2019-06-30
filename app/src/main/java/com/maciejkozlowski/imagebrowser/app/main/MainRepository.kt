package com.maciejkozlowski.imagebrowser.app.main

import com.maciejkozlowski.apihandler.mapToSuccessApiResponse
import com.maciejkozlowski.apihandler.onErrorReturnApiResponse
import com.maciejkozlowski.apihandler.response.ApiResponse
import com.maciejkozlowski.imagebrowser.api.ApiService
import com.maciejkozlowski.imagebrowser.api.errors.ApiErrorMapper
import com.maciejkozlowski.imagebrowser.api.model.Image
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val apiErrorMapper: ApiErrorMapper,
    private val imageUrlConverter: ImageUrlConverter
) {

    fun fetchList(imageWidth: Int, handleResult: (ApiResponse<List<Image>>) -> Unit): Disposable {
        return apiService
            .getList()
            .map { convertList(it, imageWidth) }
            .mapToSuccessApiResponse()
            .onErrorReturnApiResponse { apiErrorMapper.mapToApiResponse(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(handleResult)
    }

    private fun convertList(images: List<Image>, imageWidth: Int): List<Image> {
        return images.map { it.copy(url = imageUrlConverter.convertToProperSizeUrl(it.url, imageWidth.toString())) }
    }
}