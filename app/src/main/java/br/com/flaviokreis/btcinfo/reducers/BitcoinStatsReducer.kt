package br.com.flaviokreis.btcinfo.reducers

import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class BitcoinStatsReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.SAVE_BITCOIN_STATS)
    fun saveBitcoinStats(state: AppState, payload: BitcoinStats): AppState {
        return state.copy(bitcoinStats = payload)
    }

}