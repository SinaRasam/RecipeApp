package com.example.recipeapp.repository

import com.example.recipeapp.model.RecipeDomain

interface RecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<RecipeDomain>
    suspend fun get(token:String,id:Int):RecipeDomain
}