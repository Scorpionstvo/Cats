package com.example.cats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataModel : ViewModel() {

    val breedModelList: MutableLiveData<List<BreedModel>> by lazy {
        MutableLiveData<List<BreedModel>>()
    }

    fun loadBreeds() {
        viewModelScope.launch {
            val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            val catApi = retrofit.create(CatApi::class.java)
            breedModelList.value = catApi.getBreed()

        }
    }
}
