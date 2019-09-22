package br.com.flaviokreis.btcinfo.models

data class BitcoinChart(
    val status: String = "",
    val name: String = "",
    val unit: String = "",
    val period: String = "",
    val description: String = "",

    val values: BitcoinChartValues = BitcoinChartValues()
)