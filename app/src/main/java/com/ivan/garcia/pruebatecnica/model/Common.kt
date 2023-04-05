package com.ivan.garcia.pruebatecnica.model
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Patterns
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
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

fun encodeImages(path: String): String? {
    val imagefile = File(path)
    var fis: FileInputStream? = null
    try {
        fis = FileInputStream(imagefile)
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
    val bm = BitmapFactory.decodeStream(fis)
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val b: ByteArray = baos.toByteArray()
    val imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT)
    return imgDecodableString
}


fun isValidEmail(email: String): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

fun isValidDate(email: String): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}