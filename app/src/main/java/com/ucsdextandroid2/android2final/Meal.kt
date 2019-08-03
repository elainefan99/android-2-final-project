package com.ucsdextandroid2.android2final

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
class Meal(

    @field:SerializedName("idMeal")
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @field:SerializedName("strMeal")

    @ColumnInfo(name = "mealName")
    var mealName: String,

    @field:SerializedName("strMealThumb")

    @ColumnInfo(name = "photo")
    var photo: String


)