package br.com.flaviokreis.btcinfo.middlewares

import android.content.Context
import br.com.flaviokreis.btcinfo.actions.ActionCreator
import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.services.BitcoinServiceApi.getChart
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.BeforeAction

class BitcoinChartMiddleware(context: Context): NetworkOnMiddleware(context) {

    @BeforeAction(Actions.SYNC_BITCOIN_CHART)
    fun syncBitcoinChart(state: AppState, action: Action<*>) {
        getChart { chart, _ ->
            if (chart != null) ActionCreator.saveBitcoinChart(chart)
        }
    }
}