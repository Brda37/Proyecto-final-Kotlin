package com.example.forokotlin.utils

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.R
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()
    }

    private fun setup() {
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterUserActivity::class.java))
        }
        Common().setTitleActionBar(this, "Iniciar sesión", false, false)
    }

    private fun login() {
        val email = findViewById<EditText>(R.id.txtLoginEmail)
        val password = findViewById<EditText>(R.id.txtLoginPassword)
        if (!email.text.toString().isEmpty() && !password.text.toString().isEmpty()) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                email.text.toString(),
                password.text.toString()
            )
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MyGroupsActivity::class.java))
                    } else {
                        // Mostrar error genérico, no es necesario pasar un TitleType específico
                        Common().showAlert(TitleType.ERROR, "Error en el inicio de sesión", this)
                    }
                }
        } else {
            Common().showAlert(TitleType.ERROR, "El email y la contraseña son requeridos", this)
        }
    }

}
