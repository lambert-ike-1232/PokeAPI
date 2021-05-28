package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.Adapter.PokemonListAdapter
import com.example.myfirstapp.Common.ItemOffsetDecoration
import com.example.myfirstapp.pokemon.model.Pokemon
import com.example.myfirstapp.pokemon.service.PokemonService
import com.example.myfirstapp.pokemon.service.RetrofitClient
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import kotlinx.android.synthetic.main.fragment_pokemon_list.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class PokemonListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    //internal var iPokemonList:PokemonService
    private lateinit var adapter: PokemonListAdapter

    init {
        val retrofit = RetrofitClient.instance

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment


        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        itemView.pokemon_recyclerview.apply {

            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            val itemDecoration = ItemOffsetDecoration(activity!!, R.dimen.spacing)
            addItemDecoration(itemDecoration)




        }
        adapter = PokemonListAdapter(requireContext())
        itemView.pokemon_recyclerview.adapter = adapter



        return itemView
    }

        /*
        Create Adapter
        0 Item adapter
        Store as a member variable
        Set adapter on recyclerview
         */

        /*    class adapter(val pokemons: List<Pokemon>) :
            RecyclerView.Adapter<adapterState.MyViewHolder>() {
            inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                fun setDataState(list: Pokemon_List) {
                    Glide.with(itemView.context)
                        .load(listDM.photo)
                        .into(itemView.list)
                    itemView.listTextState.text = listDM.name
                }
            }




        }

     */


        override fun onResume() {
            super.onResume()

            lifecycleScope.launch {
/* Make API request

use adapter here

 */
                //Recyclerview.adapter = adapter


                val pokemonlist = PokemonService.instance.getPokemonList()

                adapter.setItems(pokemonlist.pokemon)


                /*
            Put Pokemon Items into adapter
            Notify dataset changed




             */


            }
        }
    }



















