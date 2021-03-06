package com.santiagoplatzi.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santiagoplatzi.platziconf.model.Conference
import com.santiagoplatzi.platziconf.network.Callback
import com.santiagoplatzi.platziconf.network.FirestoreService

class ScheduleViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object :
            Callback<List<com.santiagoplatzi.platziconf.model.Conference>> {
            override fun onSuccess(result: List<com.santiagoplatzi.platziconf.model.Conference>?) {
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
