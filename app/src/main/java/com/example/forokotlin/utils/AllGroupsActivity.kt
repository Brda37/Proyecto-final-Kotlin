package com.example.forokotlin.utils

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forokotlin.dto.Group
import com.example.forokotlin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class AllGroupsActivity : AppCompatActivity() {

    private var groups: MutableList<Group?>? = null
    private var firebaseAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null
    private var databaseReference: DatabaseReference? = null
    private var common: Common? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_groups)
        common = Common() // Inicializamos la instancia de Common

        firebaseAuth = FirebaseAuth.getInstance()
        currentUser = firebaseAuth?.currentUser
        databaseReference = FirebaseDatabase.getInstance().getReference("Groups")
        setup()
    }

    private fun setup() {
        groups = ArrayList()
        databaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val tempGroups: MutableList<Group?> = mutableListOf()
                    for (groupsByUser in snapshot.children) {
                        for (groupSnapshot in groupsByUser.children) {
                            val group: Group? = groupSnapshot.getValue(Group::class.java)
                            groups!!.add(group)
                        }
                    }
                    currentUser?.uid?.let { userUid ->
                        groups?.removeIf { group ->
                            group?.getUserUid().equals(userUid)
                        }
                    }

                    val groupAdapter = GroupAdapter(this@AllGroupsActivity, groups)
                    val recyclerView: RecyclerView = findViewById(R.id.allGroupsRecyclerView)
                    recyclerView.setHasFixedSize(true)
                    recyclerView.layoutManager = LinearLayoutManager(this@AllGroupsActivity)
                    recyclerView.adapter = groupAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        supportActionBar?.title = "Todos los grupos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
            R.id.addGroup -> {
                startActivity(Intent(this, AddGroupActivity::class.java))
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
