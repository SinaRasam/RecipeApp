package com.example.recipeapp.utils

interface DomainMapper<T,DomainModel> {
    fun mapToDomainModel(model:T):DomainModel
    fun mapFromDomainModel(model:DomainModel):T
}