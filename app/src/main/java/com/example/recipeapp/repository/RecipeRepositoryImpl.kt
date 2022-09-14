package com.example.recipeapp.repository

import com.example.recipeapp.model.RecipeDomain
import com.example.recipeapp.network.Api
import com.example.recipeapp.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val api:Api,
    private val mapper:RecipeDtoMapper
):RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<RecipeDomain> {
        var res = api.search(token = token, page = page, query = query).recipes
        return mapper.toDomainList(res.orEmpty())
    }

    override suspend fun get(token: String, id: Int): RecipeDomain {
        return mapper.mapToDomainModel(api.get(token = token, id))
    }

}