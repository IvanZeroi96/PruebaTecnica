package com.ivan.garcia.pruebatecnica.view
import UsersData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivan.garcia.pruebatecnica.model.Common
import com.ivan.garcia.pruebatecnica.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Common().baseUrlSearch)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : ApiServices = retrofit.create(ApiServices::class.java)

    val usersList = MutableLiveData<List<UsersData>>()

    fun getDataList(){
        val headerMap = HashMap<String, String>()
        headerMap["Host"] = "api.devdicio.net"
        headerMap["Content-Type"] = "application/json"
        headerMap["xc-token"] = "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP"

        val call = service.getListData(headerMap)

        call.enqueue(object: Callback<List<UsersData>>{
            override fun onResponse(call: Call<List<UsersData>>, response: Response<List<UsersData>>) {
                response.body()?.let {
                        list -> usersList.postValue(list)
                }
            }

            override fun onFailure(call: Call<List<UsersData>>, t: Throwable) {
                call.cancel()
            }
        })
    }
}