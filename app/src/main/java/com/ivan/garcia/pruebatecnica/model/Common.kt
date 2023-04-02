package com.ivan.garcia.pruebatecnica.model
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

class Common {
    val baseUrlSearch : String = "https://api.devdicio.net:8444/v1/"
}

fun decodeImageBase64 (imadeDecodeString: String): Bitmap {
    val base64Image: String = imadeDecodeString.split(",").get(1)
    val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}