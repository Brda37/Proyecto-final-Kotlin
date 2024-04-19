package com.example.forokotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forokotlin.dto.Group
import com.example.forokotlin.utils.Common
import com.example.forokotlin.utils.GroupAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class MyGroupsActivity : AppCompatActivity() {

    private var groups: MutableList<Group?>? = null
    private var firebaseAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null
    private var databaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_groups)
        setSupportActionBar(findViewById(R.id.toolbar))
        setup()
    }

    private fun setup() {
        firebaseAuth = FirebaseAuth.getInstance()
        currentUser = firebaseAuth!!.currentUser
        databaseReference = FirebaseDatabase.getInstance().getReference("Groups")
        databaseReference!!.child(currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        groups = ArrayList()
                        for (groupSnapshot in snapshot.children) {
                            val group: Group? = groupSnapshot.getValue(Group::class.java)
                            groups!!.add(group)
                        }
                        val groupAdapter = GroupAdapter(this@MyGroupsActivity, groups)
                        val recyclerView: RecyclerView = findViewById(R.id.myGroupsRecyclerView)
                        recyclerView.setHasFixedSize(true)
                        recyclerView.layoutManager = LinearLayoutManager(this@MyGroupsActivity)
                        recyclerView.adapter = groupAdapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        supportActionBar?.title = "Mis grupos"
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
            R.id.allGroups -> {
                startActivity(Intent(this, AllGroupsActivity::class.java))
                return true
            }
            R.id.logout -> {
                Common().logout(this)
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
