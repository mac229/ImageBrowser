package com.maciejkozlowski.imagebrowser.api.errors

import com.maciejkozlowski.apihandler.Parser
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class ApiErrorParser @Inject constructor() : Parser<List<Error>> {

    override fun parseFromJson(json: String): List<Error>? {
        TODO() // Check api error mapper
    }
}