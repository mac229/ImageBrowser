package com.maciejkozlowski.imagebrowser.api

import com.maciejkozlowski.imagebrowser.api.model.Image
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

interface ApiService {

    @GET("list")
    fun getList(): Single<List<Image>>


}