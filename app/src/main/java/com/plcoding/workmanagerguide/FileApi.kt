package com.plcoding.workmanagerguide

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface FileApi {

    @GET("/photo/2015/04/23/22/00/tree-736885_960_720.jpg")
    suspend fun downloadImage(): Response<ResponseBody>
    companion object {
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl("https://cdn.pixabay.com")
                .build()
                .create(FileApi::class.java)
        }
    }

}