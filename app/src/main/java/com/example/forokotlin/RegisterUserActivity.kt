package com.example.forokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.dto.User
import com.example.forokotlin.utils.Common
import com.example.forokotlin.utils.TitleType
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterUserActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    private var name: EditText? = null
    private var lastname: EditText? = null
    private var age: EditText? = null
    private var email: EditText? = null
    private var password: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
        setSupportActionBar(findViewById(R.id.toolbar))
        setup()
    }

    private fun setup() {
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        name = findViewById(R.id.txtName)
        lastname = findViewById(R.id.txtLastname)
        age = findViewById(R.id.txtAge)
        email = findViewById(R.id.txtRegisterEmail)
        password = findViewById(R.id.txtRegisterPassword)
        btnRegister.setOnClickListener {
            registerUser()
        }
        Common().setTitleActionBar(this, "Registrarse", Common.SHOW_BACK_BUTTON, Common.SHOW_HOME_BUTTON)
    }

    private fun registerUser() {
        firebaseAuth = FirebaseAuth.getInstance()
        if (email!!.text.toString().isNotEmpty() && password!!.text.toString().isNotEmpty()) {
            firebaseAuth!!.createUserWithEmailAndPassword(
                email!!.text.toString(),
                password!!.text.toString()
            )
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        saveUserData()
                        startActivity(Intent(this, LogInActivity::class.java))
                    } else {
                        Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Common().showAlert(TitleType.ERROR, "El email y la contraseña son requeridos", this)
        }
    }

    private fun saveUserData() {
        val uid = firebaseAuth!!.uid
        val user = User()
        user.setUid(uid)
        user.setName(name!!.text.toString())
        user.setLastname(lastname!!.text.toString())
        user.setAge(age!!.text.toString().toInt())
        user.setEmail(email!!.text.toString())
        user.setPassword(password!!.text.toString())
        val databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uid!!).setValue(user)
            .addOnCompleteListener { task: Task<Void> ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    Common().showAlert(TitleType.ERROR, "Error al agregar el grupo", this)
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
