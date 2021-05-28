package com.example.myfirstapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.pokemon.model.Pokemon

class PokemonListAdapter(internal var context: Context):RecyclerView.Adapter<PokemonListAdapter.MyViewHolder>() {
    private val pokemonList= mutableListOf<Pokemon>()
    inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        internal var img_pokemon:ImageView
        internal var txt_pokemon:TextView
        init {

            img_pokemon = itemView.findViewById(R.id.pokemon_image) as ImageView
            txt_pokemon = itemView.findViewById(R.id.pokemon_name) as TextView
      //      Recyclerview.adapter = adapter

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].img.replace("http","https")).into(holder.img_pokemon)
        holder.txt_pokemon.text = pokemonList[position].name
    }

    override fun getItemCount(): Int {

        return pokemonList.size
    }


    fun setItems(items: List<Pokemon>){

        pokemonList.clear()
        pokemonList.addAll(items)
        notifyDataSetChanged()


    }


}