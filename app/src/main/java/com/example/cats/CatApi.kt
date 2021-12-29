package com.example.cats

import com.example.cats.BuildConfig.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatApi {
    @Headers("api-key: $API_KEY")
    @GET("breeds")
    suspend fun getBreed(@Query("limit") limit: Int = 20): List<BreedModel>

}
