package com.santiagoplatzi.platziconf.view.adapter

import com.santiagoplatzi.platziconf.model.Speaker


interface SpeakerListener {
    fun onSpeakerClick(speaker: Speaker, position: Int) {}
}