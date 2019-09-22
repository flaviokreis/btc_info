package br.com.flaviokreis.btcinfo.actions

import br.com.flaviokreis.btcinfo.BitcoinApplication
import br.com.flaviokreis.btcinfo.actions.Actions.LOADED_DATABASE
import br.com.flaviokreis.btcinfo.actions.Actions.LOAD_DATABASE
import br.com.flaviokreis.btcinfo.actions.Actions.SAVE_BITCOIN_CHART
import br.com.flaviokreis.btcinfo.actions.Actions.SAVE_BITCOIN_STATS
import br.com.flaviokreis.btcinfo.actions.Actions.SYNC_BITCOIN_CHART
import br.com.flaviokreis.btcinfo.actions.Actions.SYNC_BITCOIN_STATS
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import com.github.raulccabreu.redukt.actions.Action

object ActionCreator {

    fun loadDatabase() {
        asyncDispatch(Action<Any>(LOAD_DATABASE))
    }

    fun loadedDatabase(state: AppState) {
        asyncDispatch(Action<Any>(LOADED_DATABASE, state))
    }

    fun syncBitcoinStats() {
        asyncDispatch(Action<Any>(SYNC_BITCOIN_STATS))
    }

    fun saveBitcoinStats(bitcoinStats: BitcoinStats) {
        asyncDispatch(Action(SAVE_BITCOIN_STATS, bitcoinStats))
    }

    fun syncBitcoinChart() {
        asyncDispatch(Action<Any>(SYNC_BITCOIN_CHART))
    }

    fun saveBitcoinChart(bitcoinChart: BitcoinChart) {
        asyncDispatch(Action(SAVE_BITCOIN_CHART, bitcoinChart))
    }

    private fun asyncDispatch(action: Action<*>) {
        BitcoinApplication.redukt.dispatch(action, true)
    }

}