package com.bcp.bank.proyectofinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcp.bank.proyectofinal.data.entities.AllCharacterResponse
import com.bcp.bank.proyectofinal.data.entities.PokemonCharacter
import com.bcp.bank.proyectofinal.data.entities.RMCharacter
import com.bcp.bank.proyectofinal.data.remote.Result
import com.bcp.bank.proyectofinal.data.repository.RMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RMViewModel @Inject constructor(private val repository: RMRepository) : ViewModel() {


    private val _listCharacter =
        MutableLiveData<AllCharacterResponse>() //Sera usado a nivel de ViewModel
    val listCharacter: LiveData<AllCharacterResponse> = _listCharacter // Sera usado en el activity


    private val _character = MutableLiveData<RMCharacter>()
    val character: LiveData<RMCharacter> = _character

    private val _pokemonCharacter = MutableLiveData<PokemonCharacter>()
    val pokemonCharacter: LiveData<PokemonCharacter> = _pokemonCharacter


    fun doListAllCharacter() {


        viewModelScope.launch {


            val result: Result<AllCharacterResponse> = withContext(Dispatchers.IO) {

                repository.listAllCharacter()

            }


            when (result) {
                is Result.Success -> {
                    _listCharacter.value = result.data

                }

                is Result.ApiError -> {

                }
            }

        }


    }


    fun doGetCharacter(id: String) {


        viewModelScope.launch {


            val result: Result<RMCharacter> = withContext(Dispatchers.IO) {

                repository.getSingleCharacter(id = id)

            }


            when (result) {
                is Result.Success -> {
                    _character.value = result.data

                }

                is Result.ApiError -> {

                }
            }

        }


    }

    fun doGetPokemonCharacter(id: String) {
        viewModelScope.launch {
            var result: Result<PokemonCharacter> = withContext(Dispatchers.IO) {
                repository.getSinglePokemonById(id = id)
            }

            when (result) {
                is Result.Success -> {
                    _pokemonCharacter.value = result.data
                }

                is Result.ApiError -> {

                }
            }
        }
    }


}