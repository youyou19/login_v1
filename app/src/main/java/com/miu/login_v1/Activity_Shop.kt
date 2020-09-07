package com.miu.login_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shop.*
class activity_Shop : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        var intent= getIntent()
        var  emails= intent.getStringExtra("email")
        welcome.setText("welcome $emails")
    }
    fun electronicClick(view: View) {
        Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
    }
    fun clothClick(view: View) {
        Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
    }
    fun beautyClick(view: View) {
        Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
    }
    fun foodClick(view: View) {
        Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
    }
}