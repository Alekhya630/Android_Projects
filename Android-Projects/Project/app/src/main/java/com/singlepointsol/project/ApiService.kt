package com.singlepointsol.project

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("?key=47634762-688ca563c5b4378954b8c09d3&q=flowers&image_type=photo&pretty=true")
    suspend fun getFlowers(): Response<FlowerResponse>
}
