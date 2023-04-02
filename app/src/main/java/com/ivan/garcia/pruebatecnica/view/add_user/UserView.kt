package com.ivan.garcia.pruebatecnica.view.add_user
import com.ivan.garcia.pruebatecnica.model.Common
import com.ivan.garcia.pruebatecnica.model.add_user.ModelRegister
import com.ivan.garcia.pruebatecnica.model.add_user.ResponseRegister
import com.ivan.garcia.pruebatecnica.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserView  {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Common().baseUrlSearch)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : ApiServices = retrofit.create(ApiServices::class.java)

    fun addUserRegister(userData: ModelRegister, onResult: (ResponseRegister?) -> Unit){
        val headerMap = HashMap<String, String>()
        headerMap["Host"] = "api.devdicio.net"
        headerMap["Content-Type"] = "application/json"
        headerMap["xc-token"] = "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP"

        val call = service.registerUser(userData)

        call.enqueue(object: Callback<ResponseRegister> {
            override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>) {
                val addedUser = response.body()
                onResult(addedUser)
            }

            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                call.cancel()
            }
        })
    }
}