package com.example.vitor.misterchef.scenarios_main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.entities.Meal
import kotlinx.android.synthetic.main.fragment_meal_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException

class MealsListFragment : Fragment() {

    companion object {

        private val ARG_LIST = "arg_list"

        fun newInstance(list: ArrayList<Meal>) =
            MealsListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, list)
                }
            }
    }

    var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val meals = getMealsList()

        activity?.let{ that ->
            val adapter = MealAdapter(that, meals)
            adapter.setOnItemClickListener {position ->
                listener?.onFragmentInteraction(meals[position])
            }

            rvMeal.adapter = adapter
            rvMeal.layoutManager = LinearLayoutManager(that)

        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is MealsListFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement MealListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun getMealsList(): ArrayList<Meal>{
        val meals = arguments?.getSerializable(ARG_LIST) as ArrayList<Meal>?
        if(meals == null){
            throw NullPointerException("Meals list can not be null")
        }

        return meals
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(meal: Meal)
    }

}
