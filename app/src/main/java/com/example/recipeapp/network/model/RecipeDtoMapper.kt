package com.example.recipeapp.network.model

import com.example.recipeapp.model.RecipeDomain
import com.example.recipeapp.utils.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, RecipeDomain> {

    override fun mapToDomainModel(model: RecipeDto): RecipeDomain {
        return RecipeDomain(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients.orEmpty(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
        )
    }

    override fun mapFromDomainModel(domainModel: RecipeDomain): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    fun toDomainList(initial: List<RecipeDto>): List<RecipeDomain>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<RecipeDomain>): List<RecipeDto>{
        return initial.map { mapFromDomainModel(it) }
    }


}