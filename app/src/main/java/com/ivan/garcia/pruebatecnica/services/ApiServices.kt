package com.ivan.garcia.pruebatecnica.services
import UsersData
import com.ivan.garcia.pruebatecnica.model.add_user.ModelRegister
import com.ivan.garcia.pruebatecnica.model.add_user.ResponseRegister
import retrofit2.Call
import retrofit2.http.*

interface ApiServices{
    @GET("./")
    fun getListData(@HeaderMap token: Map<String, String>): Call<List<UsersData>>

    @Headers(
        "Accept: application/json",
        "Content-type:application/json",
        "xc-token: J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP"
    )
    @POST("./")
    fun registerUser(@Body requestBody: ModelRegister): Call<ResponseRegister>
}