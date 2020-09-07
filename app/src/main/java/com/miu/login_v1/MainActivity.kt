package com.miu.login_v1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.shoppping.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val user1: User = User("Jules", "Amazan", "pedro", "jules@gmail", "pass")
    var user2: User = User("Jules", "Amazan", "pedro", "jules@gmail", "pass")
    var user3: User = User("Jules", "Amazan", "pedro", "jules@gmail", "pass")
    var user4: User = User("Jules", "Amazan", "predo", "jules@gmail", "pass")
    var user5: User = User("Jules", "Amazan", "pedro", "jules@gmail", "pass")
    val userList: ArrayList<User> = arrayListOf(user1, user2, user3, user4, user5)
    var currentUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btsignin.setOnClickListener {
            val emailUser: String = txemail.text.toString()
            val passUser: String = txpassword.text.toString()
            for (user in userList) {
                if (user.email.equals(emailUser) && user.password.equals(passUser)) {
                    currentUser = user

                    break
                }
            }

            if (currentUser != null) {
                var intent = Intent(applicationContext, Activity_Shop::class.java);
                startActivity(intent);
                Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
            }

        }
    }
}