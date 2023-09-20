package com.example.new_about_me

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.et_name2)
        val id = findViewById<EditText>(R.id.et_id2)
        val pw = findViewById<EditText>(R.id.et_pw2)
        val mbti = findViewById<EditText>(R.id.et_mbti)
        val age = findViewById<EditText>(R.id.et_age)
        val signup = findViewById<Button>(R.id.btn_signupok)
        val close = findViewById<Button>(R.id.btn_back)

        signup.setOnClickListener {
            if (name.text.toString().trim().isEmpty() ||
                id.text.toString().trim().isEmpty() ||
                pw.text.toString().trim().isEmpty() ||
                mbti.text.toString().trim().isEmpty() ||
                age.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.Err), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", id.text.toString())
                putExtra("pw", pw.text.toString())
                putExtra("mbti", mbti.text.toString())
                putExtra("age", age.text.toString())
                putExtra("name", name.text.toString())
                Log.d("SignUpActivity", "intent = ${putExtra("name", name.text.toString())}")
            }
            setResult(RESULT_OK, intent)
            finish()
        }
        close.setOnClickListener {
            finish()
        }
    }
}