package br.com.flaviokreis.btcinfo.views.stats

import android.content.Context
import br.com.flaviokreis.btcinfo.R
import br.com.flaviokreis.btcinfo.utils.formatDouble
import br.com.flaviokreis.btcinfo.utils.formatInt
import br.com.flaviokreis.btcinfo.views.CardLayout.cardLayout
import br.com.flaviokreis.btcinfo.views.dslAddView

inline fun statsTransactionSummaryView(crossinline func: StatsTransactionSummaryView.() -> Unit) {
    dslAddView(func)
}

class StatsTransactionSummaryView(context: Context): BaseStatsView(context) {
    override fun view() {
        val totalFeesBtc = formatDouble(bitcoinStats?.totalFeesBtc)
        val nTx = formatInt(bitcoinStats?.nTx)
        val totalBtcSent = formatDouble(bitcoinStats?.totalBtcSent)
        val estimatedBtcSent = formatDouble(bitcoinStats?.estimatedBtcSent)
        val estimatedTransactionVolumeUsd = formatDouble(bitcoinStats?.estimatedTransactionVolumeUsd)

        cardLayout(context, R.string.transaction_summary, mapOf(
            R.string.total_fees_btc to "$totalFeesBtc BTC",
            R.string.number_of_transactions to "$nTx",
            R.string.total_btc_sent to "$totalBtcSent BTC",
            R.string.estimated_btc_sent to "$estimatedBtcSent BTC",
            R.string.estimated_usd_sent to "$ $estimatedTransactionVolumeUsd"
        ))
    }
}