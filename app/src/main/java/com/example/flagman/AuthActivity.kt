package com.example.flagman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.flagman.fragments.AuthFragment
import com.example.flagman.fragments.RegisterFragment

class AuthActivity : AppCompatActivity(), AuthFragment.OnDataListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        var isAuth: Boolean = true

        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonChangeFragment: Button = findViewById(R.id.buttonChangeFragment)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AuthFragment())
                .commit()
        }

        buttonChangeFragment.setOnClickListener {
            var fragment: Fragment = RegisterFragment()
            if (isAuth) {
                buttonChangeFragment.text = "Уже есть аккаунт?"
            } else {
                buttonChangeFragment.text = "Зарегистрироваться"
                fragment = AuthFragment()
            }
            isAuth = !isAuth
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
    override fun onDataReceived(data: String) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
