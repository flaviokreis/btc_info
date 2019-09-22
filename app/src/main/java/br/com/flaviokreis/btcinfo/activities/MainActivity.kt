package br.com.flaviokreis.btcinfo.activities

import android.view.View
import br.com.flaviokreis.btcinfo.actions.ActionCreator
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.views.BitcoinLayout

class MainActivity : ReactiveActivity() {
    override fun render(): View {
        return BitcoinLayout(this)
    }

    override fun initialState() {
        ActionCreator.loadDatabase()
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState.stateStarted != oldState.stateStarted
    }

    override fun onChanged(state: AppState) {
        if (state.stateStarted)
            syncContent()
    }

    private fun syncContent() {
        ActionCreator.syncBitcoinChart()
        ActionCreator.syncBitcoinStats()
    }
}
