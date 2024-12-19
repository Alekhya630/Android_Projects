package com.singlepointsol.implicitmulti

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity(), View.OnClickListener {
    lateinit var s_first_name_et: EditText
    lateinit var s_last_name_et: EditText
    lateinit var semail_et: EditText
    lateinit var spassword: EditText
    lateinit var confirmpassword: EditText
    lateinit var signupbutton: Button
    lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        s_first_name_et = findViewById(R.id.s_first_name_et)
        s_last_name_et = findViewById(R.id.s_last_name_et)
        semail_et = findViewById(R.id.semail_et)
        spassword = findViewById(R.id.spassword_et)
        confirmpassword = findViewById(R.id.sconfirm_password_et)
        signupbutton = findViewById(R.id.signup_button)
        signupbutton.setOnClickListener(this)
        sharedPreference=getSharedPreferences("SinglePointPreferences",
            MODE_PRIVATE)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {

        if (p0 != null) {
            when (p0.id) {
                R.id.signup_button -> {
                    val editor: SharedPreferences.Editor = sharedPreference.edit()
                    editor.putString("fnameKey", s_first_name_et.text.toString())
                    editor.putString("lnameKey", s_last_name_et.text.toString())
                    editor.putString("emaiKey", semail_et.text.toString())
                    editor.putString("passwordKey", spassword.text.toString())
                    editor.putString("cpasswordKey", confirmpassword.text.toString())
                    editor.apply()


                }



            }
        }
    }
}
