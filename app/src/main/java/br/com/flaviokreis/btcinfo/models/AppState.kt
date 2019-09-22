package br.com.flaviokreis.btcinfo.models

data class AppState(
    val bitcoinChart: BitcoinChart? = null,
    val bitcoinStats: BitcoinStats? = null,

    val stateStarted: Boolean = true
)