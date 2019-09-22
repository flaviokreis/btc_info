package br.com.flaviokreis.btcinfo.views.stats

import android.content.Context
import br.com.flaviokreis.btcinfo.R
import br.com.flaviokreis.btcinfo.utils.formatDouble
import br.com.flaviokreis.btcinfo.utils.formatInt
import br.com.flaviokreis.btcinfo.views.CardLayout.cardLayout
import br.com.flaviokreis.btcinfo.views.dslAddView

inline fun statsBlockSummaryView(crossinline func: StatsBlockSummaryView.() -> Unit) {
    dslAddView(func)
}

class StatsBlockSummaryView(context: Context): BaseStatsView(context) {
    override fun view() {
        val nBlocksMined = formatInt(bitcoinStats?.nBlocksMined)
        val minutesBetweenBlocks = formatDouble(bitcoinStats?.minutesBetweenBlocks)
        val nBtcMined = bitcoinStats?.nBtcMined

        cardLayout(context, R.string.block_summary, mapOf(
            R.string.blocks_mined to "$nBlocksMined",
            R.string.minutes_between_blocks to "$minutesBetweenBlocks minutos",
            R.string.bitcoins_mined to "$nBtcMined BTC"
        ))
    }
}