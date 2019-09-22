package br.com.flaviokreis.btcinfo.reducers

import br.com.flaviokreis.btcinfo.actions.Actions
import br.com.flaviokreis.btcinfo.models.AppState
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class DatabaseReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.LOADED_DATABASE)
    fun loadedDatabase(state: AppState, payload: AppState): AppState {
        return state.copy(
            bitcoinStats = payload.bitcoinStats,
            bitcoinChart = payload.bitcoinChart,
            stateStarted = true)
    }

}