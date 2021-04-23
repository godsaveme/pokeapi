package com.bcp.bank.proyectofinal.rest


import com.bcp.bank.proyectofinal.data.entities.AllCharacterResponse
import com.bcp.bank.proyectofinal.data.entities.RMCharacter
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    //region login
    @GET("character")
    suspend fun listAllCharacter(): Response<AllCharacterResponse>


    //PATH------------------------------------------------

    //https//:www.bcp.com/character/1
    //https//:www.bcp.com/character/2
    //https//:www.bcp.com/character/3
    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: String): Response<RMCharacter>


    //QUERY------------------------------------------------

    //https//:www.bcp.com/character?name=Rick&status=alive
    @GET("character")
    suspend fun filterCharacter(
        @Query("name") name: String,
        @Query("status") status: String
    ): Response<AllCharacterResponse>


    //QUERY Y PATH------------------------------------------------
    //https//:www.bcp.com/character/4/class?name=Rick&status=alive
    //https//:www.bcp.com/character/3/class?name=Rick&status=alive
    //https//:www.bcp.com/character/2/class?name=Rick&status=alive
    @GET("character/{id}/class")
    suspend fun filterCharacter2(
        @Query("name") name: String,
        @Query("status") status: String,
        @Path("id") id: String
    ): Response<AllCharacterResponse>


    //BODY------------------------------------------------

    //https//:www.bcp.com/character
    @POST("character")
    suspend fun serviceBody(
        @Body body: RMCharacter,
    ): Response<AllCharacterResponse>


}