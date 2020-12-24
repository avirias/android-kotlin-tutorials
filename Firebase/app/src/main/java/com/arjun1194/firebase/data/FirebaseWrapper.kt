package com.arjun1194.firebase.data

import com.arjun1194.firebase.data.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseWrapper {

    private val database = Firebase.database

    fun createUser(user: User,callback: TaskListener){
        val reference = database.getReference("users")
        val ref = reference.push()
        val task = ref.setValue(user).addOnSuccessListener {
            callback.onSuccess(ref.key.toString())
        }.addOnFailureListener {
            callback.onFailed(it)
        }

    }

    fun getUserName(id: String,callback: (String)->Unit) {
        val reference = database.getReference("users")
        reference.child(id).child("name").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                callback(snapshot.value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error occurred <getUserName> --> $error")
            }

        })
    }

    interface TaskListener{
        fun onSuccess(key:String)
        fun onFailed(e:Exception)
    }
}