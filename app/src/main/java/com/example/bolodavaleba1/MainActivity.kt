package com.example.bolodavaleba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var Email: EditText
    private lateinit var editTextPass: EditText
    private lateinit var buttonn: AppCompatButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       Email = findViewById(R.id.Email)
        editTextPass = findViewById(R.id.editTextPass)
        buttonn = findViewById(R.id.buttonn)


        buttonn.setOnClickListener {
            val email = Email.text.toString()
            val pass = editTextPass.text.toString()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "შეავსეთ ცარიელი ველები", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "სცადეთ თავიდან", Toast.LENGTH_SHORT).show()
                    }
                }



        }


    }
}