package br.com.flaviokreis.btcinfo.reducers

import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinChart
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class BitcoinChartReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.SAVE_BITCOIN_CHART)
    fun saveBitcoinChart(state: AppState, payload: BitcoinChart): AppState {
        return state.copy(bitcoinChart = payload)
    }

}