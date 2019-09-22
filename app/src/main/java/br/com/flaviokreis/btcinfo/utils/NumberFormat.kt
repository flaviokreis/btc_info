package br.com.flaviokreis.btcinfo.utils

import java.text.DecimalFormat
import java.util.Locale

fun formatDouble(number: Double?): String {
    if (number == null) return ""

    return DecimalFormat.getInstance(Locale.forLanguageTag("pt")).format(number)
}

fun formatInt(number: Int?): String {
    if (number == null) return ""

    return number.toString()
}