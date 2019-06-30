package com.maciejkozlowski.imagebrowser.api.errors

import com.maciejkozlowski.apihandler.BaseApiErrorMapper
import com.maciejkozlowski.apihandler.errors.ApiError
import javax.inject.Inject

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class ApiErrorMapper @Inject constructor(parser: ApiErrorParser) : BaseApiErrorMapper<List<Error>>(parser) {

    override fun createRequestError(errors: List<Error>): ApiError {
        TODO() // Basically here we handle request api error, but it's an public api and we don't structure of returned error
    }
}