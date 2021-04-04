package com.example.weekaheadapplication.yelp

import com.google.gson.annotations.SerializedName

data class YelpSearchResults(
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant(
    @SerializedName("name") val name:String,
    val location:YelpLocation,
    val categories:List<YelpCategory>,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("distance") val distanceInMeters: Double
)

data class YelpCategory(
    val title: String
)

data class YelpLocation(
    @SerializedName("address1") val address: String
)