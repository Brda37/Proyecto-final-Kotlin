package com.example.forokotlin.utils

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.R

class GroupInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
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
