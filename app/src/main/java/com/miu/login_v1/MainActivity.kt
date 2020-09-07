package com.miu.login_v1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var arr=ArrayList<User>(arrayListOf(User("Wilfrid","Jules","jules@gmail.com","1"),User("Jude","charles","charles@gmail.com","2"),User("Pierre","Jean","jean@gmail.com","3"),
        User("Pedro","Joel","joel@gmail.com","4") , User("mary","Favour","favour@gmail.com","5")
    ))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signIn(view: View) {
        var emailT=emailText.text.toString()
        var passWordT=passwordText.text.toString()

        for(a in arr){

            if(emailT.equals(a.username)&&passWordT.equals(a.password)){

                var intent = Intent(this,activity_Shop::class.java)
                intent.putExtra("email", emailT)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "invalid Email or Password", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun newAccount(view: View) {
        var intent1= Intent(this,registerActivity::class.java)
        startActivityForResult(intent1,1)
    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                val returnedResult = data!!.getSerializableExtra("user") as User

                arr.add(returnedResult)

            }
        }
    }
    fun forgotPassword(view: View) {

        var input = emailText.text.toString()
        if(input.isNullOrEmpty()){
            Toast.makeText(this, "Enter your Email address", Toast.LENGTH_LONG).show()
        }
        else{
            var userPassword:String?=null

            for(a in arr){
                if (input.equals(a.username)){ userPassword=a.password } }

            if( userPassword==null){
                Toast.makeText(this, "invalid Email Address ", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL,input)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your Password")
                intent.putExtra(Intent.EXTRA_TEXT,"your password is: $userPassword ")
                startActivity(Intent.createChooser(intent, "Send Email"))
            }
        }
    }
}
