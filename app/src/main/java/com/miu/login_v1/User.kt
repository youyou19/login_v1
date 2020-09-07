package com.miu.shoppping

import android.provider.ContactsContract

class User {

    var firstname : String=""
    var lastname : String =""
    var username : String =""
    var email : String =""
    var password : String =""
     constructor(firstname:String,lastname:String,username:String,email:String,password:String){
         this.firstname=firstname
         this.lastname=lastname
         this.username=username
         this.email=email
         this.password=password
     }
}