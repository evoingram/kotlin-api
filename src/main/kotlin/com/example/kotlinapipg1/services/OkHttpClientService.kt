package com.example.kotlinapipg1.services

import mu.two.KotlinLogging
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class OkHttpClientService {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    fun httpRequest(url: String, callback: (String?, Exception?) -> Unit): String? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            //.addHeader("Authorization", "Bearer your_token")
            .addHeader("Accept", "application/json")
            .build()
        var responseBody: String? = ""
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                responseBody = response.body?.string()
                logger.info("response in callback = $responseBody")
                callback(responseBody, null)
            }

            override fun onFailure(call: Call, e: IOException) {
                responseBody = callback(null, e).toString()
            }
        })
        return responseBody
    }
}