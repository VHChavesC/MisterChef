package com.example.vitor.misterchef.network

import com.example.vitor.misterchef.entities.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {

    @GET("https://www.themealdb.com/api/json/v1/1/latest.php")
    fun getLatestMeal(): Call<MealList>

}