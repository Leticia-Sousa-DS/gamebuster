package org.example.gamebusters.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Double.formatWithTwoDecimals(): Double {
    val decimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
    return decimalFormat.format(this).toDouble()
}