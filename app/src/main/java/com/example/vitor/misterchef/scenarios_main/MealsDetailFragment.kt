package com.example.vitor.misterchef.scenarios_main


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.entities.Meal
import kotlinx.android.synthetic.main.fragment_meal_detail.*
import kotlinx.android.synthetic.main.fragment_meal_list.*
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
                Glide.with(that)
                    .load(meal.strMealThumb)
                    .into(imgMeal)
            }

        txTitle.text = meal.strMeal
        txDate.text = meal.dateModified
        txInstruction.text = meal.strInstructions
        txIngredient1.text = meal.strIngredient1
        txIngredient2.text = meal.strIngredient2
        txIngredient3.text = meal.strIngredient3
        txIngredient4.text = meal.strIngredient4
        txIngredient5.text = meal.strIngredient5
        txIngredient6.text = meal.strIngredient6
        txIngredient7.text = meal.strIngredient7
        txIngredient8.text = meal.strIngredient8
        txIngredient9.text = meal.strIngredient9
        txIngredient10.text = meal.strIngredient10
        txIngredient11.text = meal.strIngredient11
        txIngredient12.text = meal.strIngredient12
        txIngredient13.text = meal.strIngredient13
        txIngredient14.text = meal.strIngredient14
        txIngredient15.text = meal.strIngredient15
        txIngredient16.text = meal.strIngredient16
        txIngredient17.text = meal.strIngredient17
        txIngredient18.text = meal.strIngredient18
        txIngredient19.text = meal.strIngredient19
        txIngredient20.text = meal.strIngredient20

        txMeasure1.text = meal.strMeasure1
        txMeasure2.text = meal.strMeasure2
        txMeasure3.text = meal.strMeasure3
        txMeasure4.text = meal.strMeasure4
        txMeasure5.text = meal.strMeasure5
        txMeasure6.text = meal.strMeasure6
        txMeasure7.text = meal.strMeasure7
        txMeasure8.text = meal.strMeasure8
        txMeasure9.text = meal.strMeasure9
        txMeasure10.text = meal.strMeasure10

        txCategory.text = meal.strCategory




    }


    fun getMeal(): Meal{
        val meal = arguments?.getSerializable(ARG_MEAL) as Meal?
        if(meal == null){
            throw NullPointerException("Meal can not be null")
        }

        return meal
    }


}
