package com.example.vitor.misterchef.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.entities.Meal

class MainActivity : AppCompatActivity(), MainContract.View, MealsListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()

    }

    override fun showList(meals: List<Meal>) {

        val fragmentMealsList = MealsListFragment.newInstance(meals as ArrayList<Meal>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentMealsList)
            .commit()

    }

    override fun onFragmentInteraction(meal: Meal) {
        val fragmentDetail = MealsDetailFragment.newInstance(meal)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentDetail)
            .addToBackStack(null)
            .commit()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}
