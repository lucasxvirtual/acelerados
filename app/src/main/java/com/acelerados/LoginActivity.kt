package com.acelerados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        forgot_password.setOnClickListener { startActivity<ForgotPasswordActivity>() }

        login.setOnClickListener { startActivity<MainActivity>() }

        signup.setOnClickListener { startActivity<SignUpActivity>() }
    }
}
