package br.com.flaviokreis.btcinfo.views.chart

import android.content.Context
import android.widget.LinearLayout.VERTICAL
import br.com.flaviokreis.btcinfo.R
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.utils.DateAxisFormatter
import br.com.flaviokreis.btcinfo.views.CardLayout.cardTitle
import br.com.flaviokreis.btcinfo.views.ReactRenderableView
import br.com.flaviokreis.btcinfo.views.dslAddView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.Utils
import trikita.anvil.Anvil
import trikita.anvil.BaseDSL.MATCH
import trikita.anvil.BaseDSL.WRAP
import trikita.anvil.BaseDSL.dip
import trikita.anvil.BaseDSL.margin
import trikita.anvil.BaseDSL.padding
import trikita.anvil.BaseDSL.size
import trikita.anvil.DSL.linearLayout
import trikita.anvil.DSL.orientation
import trikita.anvil.cardview.v7.CardViewv7DSL.cardView


inline fun chartMarketPriceView(crossinline func: ChartMarketPriceView.() -> Unit) {
    dslAddView(func)
}

class ChartMarketPriceView(context: Context): ReactRenderableView(context) {

    private var bitcoinChart: BitcoinChart? = null

    init {
        Utils.init(context)
    }

    override fun view() {
        cardView {
            margin(dip(8))
            linearLayout {
                size(MATCH, WRAP)
                orientation(VERTICAL)
                padding(dip(8))

                cardTitle(context.getString(R.string.market_prices))
                renderChart()
            }
        }

    }

    private fun renderChart() {
        val bitcoinChart = bitcoinChart ?: return

        val entries = bitcoinChart.values.map {
            Entry(it.x.toFloat(), it.y.toFloat())
        }.toList()

        val dataSet = LineDataSet(entries, context.getString(R.string.market_prices))
        val lineData = LineData(dataSet)

        chartView {
            size(MATCH, dip(280))
            lineData(lineData)

            val view = Anvil.currentView<ChartView>()
            view.xAxis.valueFormatter = DateAxisFormatter()
        }
    }

    fun bitcoinChart(bitcoinChart: BitcoinChart) {
        this.bitcoinChart = bitcoinChart
        Anvil.render(this)
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState.bitcoinChart != oldState.bitcoinChart
    }

    override fun onChanged(state: AppState) {
        this.bitcoinChart = state.bitcoinChart
        Anvil.render(this)
    }
}