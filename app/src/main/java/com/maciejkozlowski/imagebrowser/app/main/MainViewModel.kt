package com.maciejkozlowski.imagebrowser.app.main

import androidx.lifecycle.MutableLiveData
import com.maciejkozlowski.apihandler.errors.ConnectionError
import com.maciejkozlowski.apihandler.response.ApiResponse
import com.maciejkozlowski.imagebrowser.api.model.Image
import com.maciejkozlowski.imagebrowser.base.view.model.RxViewModel
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class MainViewModel @Inject constructor(private val repository: MainRepository) : RxViewModel() {

    val viewStateLiveData = MutableLiveData<MainViewState>()

    fun fetchList(imageWidth: Int) {
        viewStateLiveData.value = MainViewState.Loading
        repository.fetchList(imageWidth, this::handleResult).addToCompositeDisposable()
    }

    private fun handleResult(apiResponse: ApiResponse<List<Image>>) {
        viewStateLiveData.value = when (apiResponse) {
            is ApiResponse.Success<List<Image>> -> MainViewState.Content(apiResponse.data)
            is ApiResponse.Error                -> getError(apiResponse)
        }
    }

    private fun getError(apiResponse: ApiResponse.Error<List<Image>>): MainViewState {
        return when (apiResponse.error) {
            ConnectionError -> MainViewState.NoInternet
            else            -> MainViewState.UnknownError
        }
    }
}