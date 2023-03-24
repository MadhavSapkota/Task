package com.learn.task.activity.country.dto

class CountryData(
    var countryId: Int,
    var countryName: String,
    var countryInfo:String) {
    @JvmName("getGrammarId1")
    fun getCountryId(): Int {
        return countryId
    }

    @JvmName("getGrammarName1")
    fun getCountryName(): String {
        return countryName
    }

    @JvmName("getGrammarInfo1")
    fun getCountryInfo(): String {
        return countryInfo
    }
}