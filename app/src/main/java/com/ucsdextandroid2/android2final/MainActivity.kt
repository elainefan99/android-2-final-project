package com.ucsdextandroid2.android2final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataSources.getInstance().getMeals(object : DataSources.Callback<List<Meal>> {
            override fun onDataFetched(data: List<Meal>?) {
               Log.d("test", "Meals:"+ data?.size)
            }
        });
    }
}
