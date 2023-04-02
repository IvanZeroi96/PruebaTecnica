package com.ivan.garcia.pruebatecnica.view.add_user
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ivan.garcia.pruebatecnica.R
import com.ivan.garcia.pruebatecnica.model.add_user.ModelRegister
import com.ivan.garcia.pruebatecnica.model.isValidEmail
import java.util.*

class AddUserActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var secondNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var calleEditText: EditText
    private lateinit var numeroEditText: EditText
    private lateinit var coloniaEditText: EditText
    private lateinit var delegacionEditText: EditText
    private lateinit var estadoEditText: EditText
    private lateinit var cpEditText: EditText
    private lateinit var submitBtn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user_layout)

        findUI()

        submitBtn.setOnClickListener {
            validateUser()
        }

        dateEditText.setOnClickListener {
            showDatePickerDialog()
        }

    }

    private fun findUI(){
        nameEditText = findViewById(R.id.nameEditText)
        secondNameEditText = findViewById(R.id.secondNameEditText)
        lastNameEditText = findViewById(R.id.lastdNameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        dateEditText = findViewById(R.id.dateEditText)
        calleEditText = findViewById(R.id.calleEditText)
        numeroEditText = findViewById(R.id.numeroEditText)
        coloniaEditText = findViewById(R.id.coloniaEditText)
        delegacionEditText = findViewById(R.id.delegacionEditText)
        estadoEditText = findViewById(R.id.estadoEditText)
        cpEditText = findViewById(R.id.cpEditText)
        submitBtn = findViewById(R.id.submitBtn)
    }

    private fun validateUser(){
        val userName = nameEditText.text.trim()
        val secondName = secondNameEditText.text.trim()
        val lastdName = lastNameEditText.text.trim()
        val email = emailEditText.text.trim().toString()
        val date = dateEditText.text.trim()
        val calle = calleEditText.text.trim()
        val numero = numeroEditText.text.trim()
        val colonia = coloniaEditText.text.trim()
        val delegacion = delegacionEditText.text.trim()
        val estado = estadoEditText.text.trim()
        val cp = cpEditText.text.trim()
        var isCompleteForm: Boolean = true

        if(userName.isBlank()){
            nameEditText.error = "Nombre requerido"
            isCompleteForm = false
        }
        if(secondName.isBlank()){
            secondNameEditText.error = "Apellido paterno requerido"
            isCompleteForm = false
        }
        if(lastdName.isBlank()){
            lastNameEditText.error = "Apellido materno requerido"
            isCompleteForm = false
        }
        if(email.isNotBlank()){
            if(!isValidEmail(email)){
                emailEditText.error = "Email incorrecto"
                isCompleteForm = false
            }
        }else{
            emailEditText.error = "Email requerido"
            isCompleteForm = false
        }
        if(date.isBlank()){
            dateEditText.error = "Fecha de nacimiento requerido"
            isCompleteForm = false
        }
        if(calle.isBlank()){
            calleEditText.error = "Calle requerido"
            isCompleteForm = false
        }
        if(numero.isBlank()){
            numeroEditText.error = "Numero requerido"
            isCompleteForm = false
        }
        if(colonia.isBlank()){
            coloniaEditText.error = "Colonia requerido"
            isCompleteForm = false
        }
        if(delegacion.isBlank()){
            delegacionEditText.error = "Delegacion / Municipio requerido"
            isCompleteForm = false
        }
        if(estado.isBlank()){
            estadoEditText.error = "Estado requerido"
            isCompleteForm = false
        }
        if(cp.isBlank()){
            cpEditText.error = "Codigo Postal requerido"
            isCompleteForm = false
        }

        if(isCompleteForm){
            createUser(userName.toString(),secondName.toString(),lastdName.toString(),email,date.toString())
        }
    }

    private fun showDatePickerDialog(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val response = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,mYear,mMonth,mDay -> dateEditText.setText("" + mDay + "/" + mMonth + "/" + mYear)
        },year,month,day)
        response.show()
    }

    private fun createUser(
        nombre: String,
        apellidoMaterno: String,
        apellidoPaterno: String,
        email: String,
        fechaNacimiento:String){
        val apiService = UserView()
        val userInfo = ModelRegister(
            nombre = nombre,
            apellidoMaterno = apellidoMaterno,
            apellidoPaterno = apellidoPaterno,
            email = email,
            edad = 0,
            fechaNacimiento = fechaNacimiento
        )

        apiService.addUserRegister(userInfo) {
            if(it == null){
                Toast.makeText(this,"No se registro el usuario",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Se registro el usuario",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}