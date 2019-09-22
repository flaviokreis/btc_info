package br.com.flaviokreis.btcinfo.views

import android.content.Context
import android.widget.LinearLayout.VERTICAL
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import br.com.flaviokreis.btcinfo.views.chart.chartMarketPriceView
import br.com.flaviokreis.btcinfo.views.stats.statsBlockSummaryView
import br.com.flaviokreis.btcinfo.views.stats.statsMarketView
import br.com.flaviokreis.btcinfo.views.stats.statsTransactionSummaryView
import trikita.anvil.Anvil
import trikita.anvil.BaseDSL.size
import trikita.anvil.DSL.MATCH
import trikita.anvil.DSL.linearLayout
import trikita.anvil.DSL.orientation
import trikita.anvil.DSL.scrollView

class BitcoinLayout(context: Context): ReactRenderableView(context) {
    private var bitcoinStats: BitcoinStats? = null
    private var bitcoinChart: BitcoinChart? = null

    override fun view() {
        scrollView {
            size(MATCH, MATCH)

            linearLayout {
                size(MATCH, MATCH)
                orientation(VERTICAL)

                renderChart()
                renderSummary()
            }
        }
    }

    private fun renderChart() {
        val bitcoinChart = bitcoinChart ?: return

        chartMarketPriceView {
            bitcoinChart(bitcoinChart)
        }
    }

    private fun renderSummary() {
        val stats = bitcoinStats ?: return

        statsMarketView {
            bitcoinStats(stats)
        }

        statsTransactionSummaryView {
            bitcoinStats(stats)
        }

        statsBlockSummaryView {
            bitcoinStats(stats)
        }
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState != oldState
    }

    override fun onChanged(state: AppState) {
        bitcoinStats = state.bitcoinStats
        bitcoinChart = state.bitcoinChart
        Anvil.render()
    }
}