package com.learn.task.apputlis

import com.learn.task.activity.country.dto.CountryData

object ApiConstants {
    val LOG_TAG = "DEBUG"
    const val HTTP_DIR_CACHE = "English Grammar"
    const val CACHE_SIZE = 10 * 1024 * 1024
    const val PROCESSING = "Processing....."
    const val NONETWORK = "The internet connection appears to be offline"
    const val TIME_OUT = "Network seems to be slow.Time Out"
    const val SERVERERROR = "There seems to be error in serve ,Please try again later"

    const val NEPAL = 1
    const val INDIA = 2
    const val CHINA = 3
    const val AMERICA = 4
    const val GERMANY = 5
    const val BHUTAN = 6
    const val UNITEDKINGDOM = 7
    const val RUSSIA = 8
    const val SRILANKA = 9
    const val PAKISTAN = 10

    const val nepalLink = "https://nepal.gov.np/"
    const val indiaLink = "https://www.india.gov.in/"
    const val chinaLink = "https://www.gov.cn/english/"
    const val americaLink = "https://www.state.gov/"
    const val germanyLink = "https://www.bundesregierung.de/breg-en"
    const val bhutanLink = "https://www.gov.bt/"
    const val ukLink = "https://www.gov.uk/"
    const val russiaLink = "http://government.ru/en/"
    const val srilankaLink = "https://www.gov.lk/"
    const val pakistanLink = "https://pakistan.gov.pk/"

    var selectedUrl = ""
    var countryId: Int? = null
    var countryName: String = ""
    var countryDescription: String = ""
    var countryLink:String = ""
    var countryData = ArrayList<CountryData>()

}