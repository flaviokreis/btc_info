package br.com.flaviokreis.btcinfo.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateAxisFormatter : ValueFormatter() {

    private val format = SimpleDateFormat("dd/MM/yy", Locale.US)

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return format.format(Date((value * 1000).toLong()))
    }
}