package com.kl3jvi.musicapp.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
    private val TAG = HttpRequestInterceptor::class.simpleName
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Log.d(TAG, request.toString())
        return chain.proceed(request)
    }
}