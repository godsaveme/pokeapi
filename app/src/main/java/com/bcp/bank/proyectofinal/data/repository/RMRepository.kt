package com.bcp.bank.proyectofinal.data.repository

import com.bcp.bank.proyectofinal.data.entities.AllCharacterResponse
import com.bcp.bank.proyectofinal.data.entities.PokemonCharacter
import com.bcp.bank.proyectofinal.data.entities.RMCharacter
import com.bcp.bank.proyectofinal.data.remote.RMRemoteDataSource
import com.bcp.bank.proyectofinal.data.remote.Result
import javax.inject.Inject

class RMRepository @Inject constructor(
    private val remoteDataSource: RMRemoteDataSource
) {


    suspend fun listAllCharacter(): Result<AllCharacterResponse> =
        remoteDataSource.listAllCharacter()


    suspend fun getSingleCharacter(id : String) : Result<RMCharacter> = remoteDataSource.getSingleCharacter(id = id)

    suspend fun getSinglePokemonById(id: String) : Result<PokemonCharacter> = remoteDataSource.getSinglePokemonById(id = id)

    suspend fun getSinglePokemonByName(name: String) : Result<PokemonCharacter> = remoteDataSource.getSinglePokemonByName(name = name)
}