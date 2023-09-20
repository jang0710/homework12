package com.example.new_about_me

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
    private var name2 = ""
    private var mbti2 = ""
    private var age2 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val id = findViewById<EditText>(R.id.et_Id)
        val pw = findViewById<EditText>(R.id.et_pass)
        val btn_log = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val id2 = data?.getStringExtra("id") ?: ""
                val pw2 = data?.getStringExtra("pw") ?: ""
                name2 = data?.getStringExtra("name") ?: ""
                mbti2 = data?.getStringExtra("mbti") ?: ""
                age2 = data?.getStringExtra("age") ?: ""
                id.setText(id2)
                pw.setText(pw2)
            }
        }
        btn_log.setOnClickListener {
            if (id.text.toString().trim().isEmpty() || pw.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.idpwErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent( this, HomeActivity::class.java).apply {
                putExtra("id", id.text.toString())
                putExtra("name", name2)
                putExtra("mbti", mbti2)
                putExtra("age", age2)

            }
            startActivity(intent)
        }
        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}