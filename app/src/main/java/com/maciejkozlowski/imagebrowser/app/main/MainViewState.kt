package com.maciejkozlowski.imagebrowser.app.main

import com.maciejkozlowski.imagebrowser.api.model.Image

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
sealed class MainViewState {

    data class Content(val list: List<Image>) : MainViewState()
    object Loading : MainViewState()
    object Error : MainViewState()
}