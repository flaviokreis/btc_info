package br.com.flaviokreis.btcinfo.views.stats

import android.content.Context
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import br.com.flaviokreis.btcinfo.views.ReactRenderableView
import trikita.anvil.Anvil

abstract class BaseStatsView(context: Context): ReactRenderableView(context) {

    protected var bitcoinStats: BitcoinStats? = null

    fun bitcoinStats(bitcoinStats: BitcoinStats) {
        this.bitcoinStats = bitcoinStats
        Anvil.render(this)
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState.bitcoinStats != oldState.bitcoinStats
    }

    override fun onChanged(state: AppState) {
        this.bitcoinStats = state.bitcoinStats
        Anvil.render(this)
    }
}