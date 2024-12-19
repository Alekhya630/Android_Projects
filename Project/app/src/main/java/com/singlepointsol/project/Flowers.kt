package com.singlepointsol.project

import com.google.gson.annotations.SerializedName

data class Flowers(
    @SerializedName("webformatURL")
    val flowerImage: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("likes")
    val likes: Int
)

// Wrapper class for the entire response
data class FlowerResponse(
    @SerializedName("hits")
    val hits: List<Flowers> // The list of flowers returned
)
