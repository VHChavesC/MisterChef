package com.example.vitor.misterchef.scenarios_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vitor.misterchef.R
import com.example.vitor.misterchef.R.id.imgMeal
import com.example.vitor.misterchef.entities.Meal
import kotlinx.android.synthetic.main.fragment_meal_detail.*
import kotlinx.android.synthetic.main.fragment_meal_list.*
import kotlinx.android.synthetic.main.meal_item.view.*



class MealAdapter(val context: Context, val meals: List<Meal>) : RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)) {
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, meals[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, meal: Meal, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.tvTitle.text = meal.strMeal

                Glide.with(context)
                    .load(meal.strMealThumb)
                    .into(itemView.imgMeal)


            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}