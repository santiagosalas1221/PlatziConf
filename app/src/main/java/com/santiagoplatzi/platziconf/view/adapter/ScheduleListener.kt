package com.santiagoplatzi.platziconf.view.adapter

import com.santiagoplatzi.platziconf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int) {}
}