package com.example.forokotlin.utils

import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.forokotlin.LogInActivity
import com.google.firebase.auth.FirebaseAuth


class Common {
    companion object {
        const val SHOW_BACK_BUTTON = true
        const val SHOW_HOME_BUTTON = true
    }

    fun showAlert(titleType: TitleType, message: String?, activity: AppCompatActivity) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(titleType.value)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        val dialog = builder.create()
        dialog.show()
    }

    fun setTitleActionBar(
        activity: AppCompatActivity,
        title: String?,
        showBackButton: Boolean,
        showHomeButton: Boolean
    ) {
        requireNotNull(activity.supportActionBar).apply {
            setTitle(title)
            setDisplayHomeAsUpEnabled(showBackButton)
            setDisplayShowHomeEnabled(showHomeButton)
        }
    }

    fun logout(activity: AppCompatActivity) {
        FirebaseAuth.getInstance().signOut()
        activity.startActivity(Intent(activity, LogInActivity::class.java))
        activity.finish()
    }
}
