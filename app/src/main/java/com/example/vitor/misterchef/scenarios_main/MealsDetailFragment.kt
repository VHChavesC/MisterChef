package com.example.vitor.misterchef.scenarios_main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.entities.Meal
import kotlinx.android.synthetic.main.fragment_meal_detail.*
import java.lang.NullPointerException

class MealsDetailFragment: Fragment() {

    companion object {
        private val ARG_MEAL = "arg_meal"

        fun newInstance(meal: Meal) =
            MealsDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MEAL, meal)
                }
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val meal = getMeal()

        activity?.let {that ->

        }

        txTitle.text = meal.strMeal
        txDate.text = meal.dateModified
        txInstruction.text = meal.strInstructions
        txIngredient.text = meal.strIngredient1

        btnOpenMeal.setOnClickListener{
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(meal.strYoutube)
            startActivity(openBrowser)
        }

    }

    fun getMeal(): Meal{
        val meal = arguments?.getSerializable(ARG_MEAL) as Meal?
        if(meal == null){
            throw NullPointerException("Meal can not be null")
        }

        return meal
    }


}
