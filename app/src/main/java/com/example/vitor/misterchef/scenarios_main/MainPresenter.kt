package com.example.vitor.misterchef.scenarios_main

import com.example.vitor.misterchef.entities.MealList
import com.example.vitor.misterchef.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){


        val newsService = RetrofitInicializer().createMealsService()

        val call = newsService.getLatestMeal()
        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {

                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {

                if(response.body() != null){
                    view.showList(response.body()!!.meals)
                }else {
                    view.showMessage("Sem receitas para hoje")
                }
            }
        })

    }

}