package com.example.gallery.data.repository


import com.example.gallery.data.api.RetrofitInstance
import com.example.gallery.data.model.Photos
import retrofit2.Response

class PhotosRepository {
    suspend fun getPhotos(page: Int): Response<Photos> {
        return RetrofitInstance.api.getPhotos(page)
    }
}