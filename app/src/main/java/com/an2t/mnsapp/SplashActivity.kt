package com.an2t.mnsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.an2t.mnsapp.auth.LoginActivity
import com.an2t.mnsapp.auth.vm.LoginVM

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val i  = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }, 2000)

    }
}
