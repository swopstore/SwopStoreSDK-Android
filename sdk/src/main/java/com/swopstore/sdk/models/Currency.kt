package com.swopstore.sdk.models

class Currency(val currencyCode : String,
               val displayName : String? = null,val numericCode : Int? = 0,
               val symbol  : String? = null) {



     class CurLocale {
        // expect languageCode
    }

    companion object {


        val RUB  : Currency get() { return Currency("RUB","Russian Ruble",643,"₽") }
        val USD  : Currency get() { return Currency("USD","U.S. dollar",840,"\$") }
        val SGD  : Currency get() { return Currency("SGD","Singapore dollar",702,"SGD")}
        val ZAR  : Currency get() {  return Currency("ZAR","South African rand",710,"ZAR")}
        val UYW  : Currency get() {  return Currency("UYW","",927,"UYW")}
        val CRC  : Currency get() {  return Currency("CRC","Costa Rican colon",188,"CRC")}
        val XAU  : Currency get() {  return Currency("XAU","GOLD",959,"XAU")}
        val XXX  : Currency get() {  return Currency("XXX","unknown currency",999,"XXX")}
        val BYN  : Currency get() {  return Currency("BYN","Belarusian ruble",933,"BYN")}
        val GBP  : Currency get() {  return  Currency("BYR","British pound sterling",826,"£")}
        val EUR  : Currency get() {  return  Currency("EUR","Euro",978,"€")}
        val INR  : Currency get() {  return  Currency("INR","Indian rupee",356,"₹")}
        val LKR  : Currency get() {  return  Currency("INR","Sri Lankan rupee",144,"LKR")}

    }
}