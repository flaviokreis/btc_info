package br.com.flaviokreis.btcinfo.middlewares

import br.com.flaviokreis.btcinfo.actions.ActionCreator
import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.database.ObjectBox
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.AfterAction
import com.github.raulccabreu.redukt.middlewares.BaseAnnotatedMiddleware
import com.github.raulccabreu.redukt.middlewares.BeforeAction

class DatabaseMiddleware : BaseAnnotatedMiddleware<AppState>() {

    @BeforeAction(Actions.LOAD_DATABASE)
    fun syncBitcoinStats(state: AppState, action: Action<*>) {
        val stats = ObjectBox.boxStore?.boxFor(BitcoinStats::class.java)?.get(1)
        val chart = ObjectBox.boxStore?.boxFor(BitcoinChart::class.java)?.get(1)

        ActionCreator.loadedDatabase(AppState(
            bitcoinStats = stats,
            bitcoinChart = chart
        ))
    }

    @AfterAction(Actions.SAVE_BITCOIN_STATS)
    fun saveBitcoinStats(state: AppState, action: Action<BitcoinStats>) {
        val payload = action.payload ?: return
        ObjectBox.boxStore?.boxFor(BitcoinStats::class.java)?.put(payload)
    }

    @AfterAction(Actions.SAVE_BITCOIN_CHART)
    fun saveBitcoinChart(state: AppState, action: Action<BitcoinChart>) {
        val payload = action.payload ?: return
        ObjectBox.boxStore?.boxFor(BitcoinChart::class.java)?.put(payload)
    }
}