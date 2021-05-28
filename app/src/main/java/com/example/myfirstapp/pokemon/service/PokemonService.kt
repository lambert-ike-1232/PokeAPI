package com.example.myfirstapp.pokemon.service

import android.database.Observable
import com.example.myfirstapp.pokemon.model.Pokedex
import com.example.myfirstapp.pokemon.model.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.*

interface PokemonService {

    //@get:GET("pokedex.json")
    @GET("/Biuni/PokemonGO-Pokedex/master/pokedex.json")
    suspend fun getPokemonList():
            PokemonResponse





    companion object{
        val instance= Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/").addConverterFactory(GsonConverterFactory.create()).build().create(PokemonService::class.java)
    }


}