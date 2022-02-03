package com.example.twiliovideoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared_preference.*

import android.content.SharedPreferences
import java.lang.Boolean
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.preference_dialog_number_edittext.*


class SharedPreferenceActivity : AppCompatActivity() {

    private var identity: String? = null
    var prevStarted = "yes"
    private var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_shared_preference)
        checkValue()
        sharedpreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        btnNext.setOnClickListener {
            if (TextUtils.isEmpty(edIdentity.text.toString()) == true) {
                Toast.makeText(this, "Please enter value for user", Toast.LENGTH_SHORT).show()
            } else {
                identity = edIdentity.text.toString()
                addvalue(identity.toString())
            }
            moveToSecondary()
        }


    }

    private fun addvalue(identity: String) {
        val a1 = sharedpreferences
        val editor = a1?.edit()
        editor?.putString("identity", identity)
        editor?.apply()
        editor?.commit()

    }

    private fun checkValue() {
        if (identity.toString() == null || identity.toString().isEmpty()) {
            Toast.makeText(this, "please add the value for the user", Toast.LENGTH_SHORT).show()
        } else {

            /*val a1 = sharedpreferences
            if (a1!!.getString(identity, "") == null || a1!!.getString(identity, "")!!
                    .isEmpty() == true
            ) {
                val editor = a1.edit()
                editor.putString("identity", identity)
                editor.apply()
                editor.commit()

            } else {*/
                moveToSecondary()
           // }

        }

    }

    private fun moveToSecondary() {
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent)
    }
}