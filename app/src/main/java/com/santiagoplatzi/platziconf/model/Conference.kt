package com.santiagoplatzi.platziconf.model

import java.util.*

class Conference {
    lateinit var speaker: String
    lateinit var title: String
    lateinit var description: String
    lateinit var tag: String
    lateinit var datetime: Date
    var timeInMillis: Long = 0
}