package com.ivan.garcia.pruebatecnica.model
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Patterns
import java.io.ByteArrayOutputStream
import java.util.regex.Pattern

class Common {
    val baseUrlSearch : String = "https://api.devdicio.net:8444/v1/sec_dev_interview/"
    val token : String = "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP"
}

fun decodeImageBase64 (imadeDecodeString: String): Bitmap {
    val base64Image: String = imadeDecodeString.split(",").get(1)
    val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}

fun encodeImages(bitmap: Bitmap): String? {
    try {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }catch (ex: Exception){
     return ""
    }
}


fun isValidEmail(email: String): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

fun isValidDate(email: String): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}