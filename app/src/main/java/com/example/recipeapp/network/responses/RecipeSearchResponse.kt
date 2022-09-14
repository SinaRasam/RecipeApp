package com.example.recipeapp.network.responses

import com.example.recipeapp.network.model.RecipeDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    @Expose
    val count: Int?=null,

    @SerializedName("results")
    @Expose
    val recipes: List<RecipeDto>?=null,
)