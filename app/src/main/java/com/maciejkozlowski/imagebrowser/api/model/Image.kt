package com.maciejkozlowski.imagebrowser.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
@JsonClass(generateAdapter = false)
data class Image (

    @Json(name = "id")
    val id: String,

    @Json(name = "author")
    val author: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "width")
    val width: String,

    @Json(name = "height")
    val height: String
)
