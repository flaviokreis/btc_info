package br.com.flaviokreis.btcinfo.views.chart

import android.content.Context
import br.com.flaviokreis.btcinfo.views.dslAddView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData
import trikita.anvil.Anvil

inline fun chartView(crossinline func: ChartView.() -> Unit) {
    dslAddView(func)
}

class ChartView(context: Context): LineChart(context), Anvil.Renderable {

    override fun view() {}

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    public override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

    fun lineData(data: LineData) {
        this.data = data
        Anvil.render(this)
    }
}