package com.example.recipeapp.di

import com.example.recipeapp.network.Api
import com.example.recipeapp.network.model.RecipeDtoMapper
import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        api:Api,
        mapper: RecipeDtoMapper
    ):RecipeRepository{
        return RecipeRepositoryImpl(api,mapper)
    }
}