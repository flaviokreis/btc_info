package br.com.flaviokreis.btcinfo.middlewares

import android.content.Context
import br.com.flaviokreis.btcinfo.actions.ActionCreator
import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.services.BitcoinServiceApi.getStats
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.BeforeAction

class BitcoinStatsMiddleware (context: Context): NetworkOnMiddleware(context) {

    @BeforeAction(Actions.SYNC_BITCOIN_STATS)
    fun syncBitcoinStats(state: AppState, action: Action<*>) {
        getStats { stats, _ ->
            if (stats != null) ActionCreator.saveBitcoinStats(stats)
        }
    }
}