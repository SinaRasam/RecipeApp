package com.example.recipeapp.network

import com.example.recipeapp.network.model.RecipeDto
import com.example.recipeapp.network.responses.RecipeSearchResponse
import retrofit2.http.*

interface Api {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token:String,
        @Query("page") page:Int,
        @Query("query") query:String
    ):RecipeSearchResponse

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id:Int
    ):RecipeDto
}

/*
@FormUrlEncoded
@POST("Search")
suspend fun search(
    @Field("id") id:Int
):List<RecipeDto>*/
