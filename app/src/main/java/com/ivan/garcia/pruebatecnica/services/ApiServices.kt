package com.ivan.garcia.pruebatecnica.services
import UsersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface ApiServices{
    @GET("sec_dev_interview")
    fun getListData(@HeaderMap token: Map<String, String>): Call<List<UsersData>>
}