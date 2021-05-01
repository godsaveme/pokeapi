package com.bcp.bank.proyectofinal.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.data.entities.PokemonCharacter
import com.bcp.bank.proyectofinal.databinding.FragmentMainBinding
import com.bcp.bank.proyectofinal.ui.NavigationActivity
import com.bcp.bank.proyectofinal.ui.adapter.MainAdapter
import com.bcp.bank.proyectofinal.util.style.ButtonBuilder
import com.bcp.bank.proyectofinal.util.style.TextViewBuilder
import com.bcp.bank.proyectofinal.viewmodel.RMViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: RMViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var  adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMainBinding.inflate(inflater, container, false)

        initializeUI()



        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = MainAdapter()


        //binding.rviMain.layoutManager = LinearLayoutManager(this.context)
        //binding.rviMain.adapter = adapter


        adapter.arrayMain = listOf("uno", "dos", "tres", "cuatro", "cinco", "seis")

        configureBtnSearchListener()

        setupViewModel()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewModel() {
        viewModel.pokemonCharacter.observe(requireActivity(), pokemonCharacterObserver)
    }

    private val pokemonCharacterObserver = Observer<PokemonCharacter> {
            binding.txtSearch.text = it.name

            Picasso.get()
                .load(it.sprites.front_default)
                .into(binding.imgSearch)
    }

    private fun initializeUI(){
        TextViewBuilder(binding.txtTitle)
            .textColor(R.color.pokeApiMain)
            .textSize(20f)
            .textInt(R.string.pokeApi_frg_one_title)

        TextViewBuilder(binding.txtSecond)
            .textColor(R.color.pokeApiThird)
            .textSize(18f)
            .textInt(R.string.pokeApi_frg_one_second)

        ButtonBuilder(binding.btnBuscar)
            .textInt(R.string.pokeApi_frg_one_btn_search)
            .background(R.color.pokeApiMain, 16f)
            .textColor(R.color.colorWhite)
            .textSize(16f)

        //EditTextBuilder(binding.editTxtSearch)
        //    .setHint(R.string.pokeApi_frg_one_placeholder)

        TextViewBuilder(binding.txtSearch)
            .textColor(R.color.pokeApiThird)
            .textSize(20f)


    }

    private fun configureBtnSearchListener(){
        binding.btnBuscar.setOnClickListener {
            val editTxtSearch = binding.editTxtSearch.text.toString()
            viewModel.doGetPokemonCharacter(editTxtSearch)
        }
    }

}

