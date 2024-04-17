package com.example.forokotlin.utils

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.dto.Group
import com.example.forokotlin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.forokotlin.Status

class AddGroupActivity : AppCompatActivity() {

    private var firebaseAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null
    private var databaseReference: DatabaseReference? = null
    private var common: Common? = null

    private var userUid: String? = null
    private var name: EditText? = null
    private var description: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_group)
        setup()
    }

    private fun setup() {
        firebaseAuth = FirebaseAuth.getInstance()
        currentUser = firebaseAuth?.currentUser
        databaseReference = FirebaseDatabase.getInstance().getReference("Groups")
        userUid = currentUser?.uid
        name = findViewById(R.id.groupName)
        description = findViewById(R.id.groupDescription)
        val btnAddGroup: Button = findViewById(R.id.btnAddGroup)
        common = Common()
        btnAddGroup.setOnClickListener { view ->
            addGroup(view)
        }
        supportActionBar?.title = "Agregar grupo"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addGroup(view: View) {
        val groupName = name?.text.toString().trim()
        val groupDescription = description?.text.toString().trim()

        if (groupName.isEmpty() || groupDescription.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val group = Group(userUid, name, groupDescription, Status.ACTIVE)
        val groupRef = databaseReference?.child(userUid ?: "")?.push()

        groupRef?.setValue(group)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Grupo agregado", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MyGroupsActivity::class.java))
                finish()
            } else {
                common?.showAlert(TitleType.ERROR, "Error al agregar el grupo", this) // Usamos la instancia de Common
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.userConfig -> {
                startActivity(Intent(this, UserConfigurationActivity::class.java))
                return true
            }
            R.id.allGroups -> {
                startActivity(Intent(this, AllGroupsActivity::class.java))
                return true
            }
            R.id.myGroups -> {
                startActivity(Intent(this, MyGroupsActivity::class.java))
                return true
            }
            R.id.logout -> {
                common?.logout(this) // Usamos la instancia de Common para el logout
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
