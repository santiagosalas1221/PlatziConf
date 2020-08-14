package com.santiagoplatzi.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.santiagoplatzi.platziconf.model.Speaker
import com.santiagoplatzi.platziconf.network.Callback
import com.santiagoplatzi.platziconf.network.FirestoreService

class SpeakersViewModel() {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    fun getSpeakerFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}