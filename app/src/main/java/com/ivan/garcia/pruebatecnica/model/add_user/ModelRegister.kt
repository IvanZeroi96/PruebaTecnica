package com.ivan.garcia.pruebatecnica.model.add_user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ModelRegister (
    @Expose @SerializedName("nombre") val nombre: String,
    @Expose @SerializedName("apellidoPaterno") val apellidoPaterno: String,
    @Expose @SerializedName("apellidoMaterno") val apellidoMaterno: String,
    @Expose @SerializedName("edad") val edad: Int,
    @Expose @SerializedName("email") val email: String,
    @Expose @SerializedName("fechaNac") val fechaNacimiento: String,
    @Expose @SerializedName("datos") val datos: DirectionData? = null
)

data class DirectionData (
    @Expose @SerializedName("calle") val calle: String,
    @Expose @SerializedName("numero") val numero: String,
    @Expose @SerializedName("colonia") val colonia: String,
    @Expose @SerializedName("delegacion") val delegacion: String,
    @Expose @SerializedName("estado") val estado: String,
    @Expose @SerializedName("cp") val cp: String,
    @Expose @SerializedName("imagen") val imagen: String,
)
