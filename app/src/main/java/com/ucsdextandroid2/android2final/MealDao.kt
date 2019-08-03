package com.ucsdextandroid2.android2final

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room


@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meal: Meal)

    @Delete
    fun deleteMeal(meal: Meal)

    @Query("SELECT * FROM meal")
    fun getAllMeal(): List<Meal>

    @Query("SELECT * FROM meal ORDER BY mealName DESC")
    fun getAllMealsLiveData(): LiveData<List<Meal>>

}