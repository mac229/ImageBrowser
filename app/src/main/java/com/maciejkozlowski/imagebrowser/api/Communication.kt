package com.maciejkozlowski.imagebrowser.api

import com.maciejkozlowski.imagebrowser.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

class Communication {

    val apiService: ApiService

    init {
        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://picsum.photos/v2/"
    }
}