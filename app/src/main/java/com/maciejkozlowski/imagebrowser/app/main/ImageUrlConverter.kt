package com.maciejkozlowski.imagebrowser.app.main

import androidx.core.net.toUri
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class ImageUrlConverter @Inject constructor() {

    fun convertToProperSizeUrl(url: String, width: String): String {
        val uri = url.toUri()
        val path = uri.path!!
        val newUri = url
            .substringBefore(path)
            .toUri()
            .buildUpon()
            .appendPath(uri.pathSegments[0])
            .appendPath(uri.pathSegments[1])
            .appendPath(width)
            .appendPath(width)
            .build()

        return newUri.toString()
    }
}