package com.ivan.garcia.pruebatecnica.model.add_user
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseRegister (
    @Expose @SerializedName("msg") val mensaje: String,
)