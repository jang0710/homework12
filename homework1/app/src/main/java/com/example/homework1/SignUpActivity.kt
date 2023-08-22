package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val et_name = findViewById<EditText>(R.id.et_name2)
        val et_id = findViewById<EditText>(R.id.et_id2)
        val et_pw = findViewById<EditText>(R.id.et_pw2)
        val et_mbti = findViewById<EditText>(R.id.et_mbti)
        val et_age = findViewById<EditText>(R.id.et_age)
        val btn_signup = findViewById<Button>(R.id.btn_signupok)

        btn_signup.setOnClickListener {
            if (et_name.text.toString().trim().isEmpty()||
                et_id.text.toString().trim().isEmpty()||
                et_pw.text.toString().trim().isEmpty()||
                et_mbti.text.toString().trim().isEmpty()||
                et_age.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.toast_msg_Err), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                Toast.makeText(this, getString(R.string.toast_msg_idErr),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", et_id.text.toString())
                putExtra("pw", et_pw.text.toString())
                putExtra("mbti", et_mbti.text.toString())
                putExtra("age", et_age.text.toString())
            }

            setResult(RESULT_OK, intent) // RESULT_OK = -1로 정의 되어 있다.

            if (!isFinishing) finish() // 회원가입을 하고 나면 화면을 종료 / (!isFinishing) = 화면이 종료중인지 체크
        }

        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
            finish()
        }
    }
}