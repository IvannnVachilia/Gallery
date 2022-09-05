package com.example.gallery.data.api


import com.example.gallery.data.model.Photos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("photos/?client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9")
    suspend fun getPhotos(@Query("page") page: Int): Response<Photos>

}