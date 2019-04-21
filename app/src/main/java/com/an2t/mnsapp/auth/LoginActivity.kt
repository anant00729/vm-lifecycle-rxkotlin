package com.an2t.mnsapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.an2t.mnsapp.MainActivity
import com.an2t.mnsapp.maps.MapsActivity
import com.an2t.mnsapp.R
import com.an2t.mnsapp.auth.vm.LoginVM


import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bottom_bar_ssconfirm.*

class LoginActivity : AppCompatActivity() {


    lateinit var mLVM: LoginVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLVM = ViewModelProviders.of(this).get(LoginVM::class.java)
        _addListeners()
        _observe()
    }

    private fun _observe() {
        mLVM.l_res.observe(this,
            Observer { l_res ->
                l_res?.let {
                    if (it.status) {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    } else {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            })
    }

    private fun _addListeners() {
        con_pick_seat.setOnClickListener {
            var username = in_email_phone.text.toString()
            var pass = in_password.text.toString()


            var u = User()
            u.password = pass
            u.username = username
            mLVM.callLogin(u)
        }
    }


}
