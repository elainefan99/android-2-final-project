package com.ucsdextandroid2.android2final;

import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("idMeal")
    private String id;
    @SerializedName("strMeal")
    private String mealName;
    @SerializedName("strMealThumb")
    private String photo;

    public Meal(String id, String mealName, String photo) {
        this.id = id;
        this.mealName = mealName;
        this.photo = photo;

    }

    public String getId () {
        return id;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getMealName () {
        return mealName;
    }

    public void setMealName (String mealName){
        this.mealName = mealName;
    }

    public String getPhoto () {
        return photo;
    }
    public void setPhoto (String photo){
        this.photo = photo;
    }
}

