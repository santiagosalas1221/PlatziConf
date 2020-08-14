package com.santiagoplatzi.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.santiagoplatzi.platziconf.model.Conference
import com.santiagoplatzi.platziconf.model.Speaker

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callBack: Callback<List<Speaker>>) {
        firebaseFirestore.collection("speakers")
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callBack.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callBack: Callback<List<Conference>>) {
        firebaseFirestore.collection("conferences")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callBack.onSuccess(list)
                    break
                }
            }
    }
}