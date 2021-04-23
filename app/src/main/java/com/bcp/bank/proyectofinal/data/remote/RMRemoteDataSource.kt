package com.bcp.bank.proyectofinal.data.remote

import com.bcp.bank.proyectofinal.rest.ApiService
import javax.inject.Inject


class RMRemoteDataSource @Inject constructor(
    private val service: ApiService
) : BaseDataSource() {

    suspend fun listAllCharacter() = safeApiCall { service.listAllCharacter() }


    suspend fun getSingleCharacter(id: String) = safeApiCall { service.getSingleCharacter(id = id) }

}