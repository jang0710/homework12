package com.example.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_log = findViewById<Button>(R.id.btn_log)
        val btn_signUp = findViewById<Button>(R.id.btn_signup)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val user_id = it.data?.getStringExtra("id") ?: ""
                val user_pw = it.data?.getStringExtra("pw") ?: ""
                et_id.setText(user_id)
                et_pw.setText(user_pw)
            }
        }

        btn_log.setOnClickListener {
            if (et_id.text.toString().trim().isEmpty() || et_pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_idpgErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", et_id.text.toString())
            startActivity(intent)
        }

        btn_signUp.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            activityResultLauncher.launch(intent)

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}