package com.example.weekaheadapplication.yelp

import com.google.gson.annotations.SerializedName

data class YelpSearchResults(
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant(
    @SerializedName("name") val name:String
)