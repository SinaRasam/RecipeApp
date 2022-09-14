package com.example.recipeapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeDto(

    @SerializedName("pk")
    @Expose
    var pk: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("publisher")
    @Expose
    var publisher: String? = null,

    @SerializedName("featured_image")
    @Expose
    var featuredImage: String? = null,

    @SerializedName("rating")
    @Expose
    var rating: Int? = 0,

    @SerializedName("source_url")
    @Expose
    var sourceUrl: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("cooking_instructions")
    @Expose
    var cookingInstructions: String? = null,

    @SerializedName("ingredients")
    @Expose
    var ingredients: List<String>? = null,

    @SerializedName("date_added")
    @Expose
    var dateAdded: String? = null,

    @SerializedName("date_updated")
    @Expose
    var dateUpdated: String? = null,
)