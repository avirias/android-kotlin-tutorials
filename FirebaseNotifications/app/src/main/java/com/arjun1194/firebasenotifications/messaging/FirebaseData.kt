package com.arjun1194.firebasenotifications.messaging

import com.google.firebase.database.FirebaseDatabase


class FirebaseData {

    fun uploadLog(msg: String){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        myRef.push().setValue(msg)
    }
}