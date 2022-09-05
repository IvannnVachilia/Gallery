package com.example.gallery.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gallery.data.model.Photos
import com.example.gallery.data.repository.PhotosRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PhotoListViewModel : ViewModel() {
    private var repository = PhotosRepository()
    val list: MutableLiveData<Response<Photos>> = MutableLiveData()

    fun getPhotos(page: Int){
        viewModelScope.launch {
            list.value = repository.getPhotos(page)
        }
    }
}