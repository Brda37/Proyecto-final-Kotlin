package com.example.forokotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.forokotlin.utils.Common
import com.example.forokotlin.utils.TitleType

class UserConfigurationActivity : AppCompatActivity() {

    private var users: DatabaseReference? = null
    private var currentUser: FirebaseUser? = null
    private var firebaseAuth: FirebaseAuth? = null
    private var txtNameUpdate: EditText? = null
    private var txtLastnameUpdate: EditText? = null
    private var txtAgeUpdate: EditText? = null
    private var txtEmailUpdate: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_data)
        setSupportActionBar(findViewById(R.id.toolbar))
        setup()
    }

    private fun setup() {
        firebaseAuth = FirebaseAuth.getInstance()
        currentUser = firebaseAuth?.currentUser
        users = FirebaseDatabase.getInstance().getReference("Users")

        txtNameUpdate = findViewById(R.id.txtNameUpdate)
        txtLastnameUpdate = findViewById(R.id.txtLastnameUpdate)
        txtAgeUpdate = findViewById(R.id.txtAgeUpdate)
        txtEmailUpdate = findViewById(R.id.txtEmailUpdate)

        users?.child(currentUser?.uid!!)?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val name = snapshot.child("name").value.toString()
                    val lastname = snapshot.child("lastname").value.toString()
                    val age = snapshot.child("age").value.toString()
                    val email = snapshot.child("email").value.toString()

                    txtNameUpdate?.setText(name)
                    txtLastnameUpdate?.setText(lastname)
                    txtAgeUpdate?.setText(age)
                    txtEmailUpdate?.setText(email)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })

        val btnUpdate = findViewById<Button>(R.id.button)
        btnUpdate.setOnClickListener { updateUser() }
        Common().setTitleActionBar(this, "Configuración", true, true)
    }

    private fun updateUser() {
        val uid = currentUser?.uid

        users?.child(uid!!)?.apply {
            child("name").setValue(txtNameUpdate?.text.toString())
            child("lastname").setValue(txtLastnameUpdate?.text.toString())
            child("age").setValue(txtAgeUpdate?.text.toString())
            child("email").setValue(txtEmailUpdate?.text.toString())
        }

        Common().showAlert(TitleType.SUCCESS, "Datos actualizados correctamente", this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addGroup -> {
                startActivity(Intent(this, AddGroupActivity::class.java))
                true
            }
            R.id.allGroups -> {
                startActivity(Intent(this, AllGroupsActivity::class.java))
                true
            }
            R.id.myGroups -> {
                startActivity(Intent(this, MyGroupsActivity::class.java))
                true
            }
            R.id.logout -> {
                Common().logout(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
