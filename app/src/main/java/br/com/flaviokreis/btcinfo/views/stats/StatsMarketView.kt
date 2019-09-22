package br.com.flaviokreis.btcinfo.views.stats

import android.content.Context
import br.com.flaviokreis.btcinfo.R
import br.com.flaviokreis.btcinfo.utils.formatDouble
import br.com.flaviokreis.btcinfo.views.CardLayout.cardLayout
import br.com.flaviokreis.btcinfo.views.dslAddView

inline fun statsMarketView(crossinline func: StatsMarketView.() -> Unit) {
    dslAddView(func)
}

class StatsMarketView(context: Context): BaseStatsView(context) {
    override fun view() {
        val marketPriceUsd = formatDouble(bitcoinStats?.marketPriceUsd)
        val tradeVolumeUsd = formatDouble(bitcoinStats?.tradeVolumeUsd)
        val tradeVolumeBtc = formatDouble(bitcoinStats?.tradeVolumeBtc)

        cardLayout(context, R.string.market_summary, mapOf(
            R.string.market_price to "$ $marketPriceUsd",
            R.string.trade_volume_usd to "$ $tradeVolumeUsd",
            R.string.trade_volume_btc to "$tradeVolumeBtc BTC"
        ))
    }
}