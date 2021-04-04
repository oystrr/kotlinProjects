package com.example.weekaheadapplication.yelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weekaheadapplication.R
import kotlinx.android.synthetic.main.activity_yelp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MAINACTIVITY"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "7vpxUYOe-2QdbKpI3BoyHsXjpdcTXtTEhaQiZ_Ns7wupICxOQL6e9BfyfNTd06zNMlb-KoNfyMg734qtLLw2h5XX2M2Mjt8FtnO6L-LPgMk_RPLeXIPlE2b1_Z9nYHYx"
class YelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yelp)

        val restaurants = mutableListOf<YelpRestaurant>()
        val adapter = RestaurantsAdapter(this, restaurants)
        rvRestaurants.adapter = adapter
        rvRestaurants.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        //checking for git connect
        val yelpService = retrofit.create(YelpService::class.java)
        yelpService.searchRestaurants("Bearer $API_KEY","Avocado", "New York")
                .enqueue(object : Callback<YelpSearchResults> {
                    override fun onResponse(call: Call<YelpSearchResults>, response: Response<YelpSearchResults>) {
                        Log.i(TAG, "onResponse $response")
                        val body = response.body()
                        if (body == null){
                            Log.w(TAG, "Did not receive valid response")
                            return
                        }
                        restaurants.addAll(body.restaurants)
                        adapter.notifyDataSetChanged()

                    }

                    override fun onFailure(call: Call<YelpSearchResults>, t: Throwable) {
                        Log.i(TAG, "onFailure $t")
                    }

                })
    }
}