package com.example.vitor.misterchef.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.entities.Meal
import kotlinx.android.synthetic.main.fragment_meal_list.*

class MainActivity : AppCompatActivity(), MainContract.View, MealsListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()

        val random = findViewById<Button>(R.id.btnRandom)

        random.setOnClickListener {
            val presenter: MainContract.Presenter = MainPresenter(this)
            presenter.onLoadList2()
        }

    }

    override fun showList(meals: List<Meal>) {

        val fragmentMealsList = MealsListFragment.newInstance(meals as ArrayList<Meal>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentMealsList)
            .addToBackStack(null)
            .commit()

    }

    override fun showMeal(meal: List<Meal>){
        val fragmentMealsList = MealsListFragment.newInstance(meal as ArrayList<Meal>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentMealsList)
            .addToBackStack(null)
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
