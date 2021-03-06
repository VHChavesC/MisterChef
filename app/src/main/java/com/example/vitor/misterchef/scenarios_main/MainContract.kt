package com.example.vitor.misterchef.scenarios_main

import com.example.vitor.misterchef.entities.Meal

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(meals: List<Meal>)
    }

    interface Presenter {
        fun onLoadList()
    }

}