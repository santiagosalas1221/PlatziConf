package com.santiagoplatzi.platziconf.view.adapter

import com.santiagoplatzi.platziconf.model.Conference

interface ScheduleListener {
    fun onConferenceClick(conference: Conference, position: Int) {}
}