package br.com.flaviokreis.btcinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.flaviokreis.btcinfo.actions.ActionCreator
import br.com.flaviokreis.btcinfo.models.AppState
import com.github.raulccabreu.redukt.states.StateListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BitcoinApplication.redukt.listeners.add(object : StateListener<AppState> {
            override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
                return newState != oldState
            }

            override fun onChanged(state: AppState) {
                println("App state: $state")
            }
        })

        ActionCreator.syncBitcoinStats()
        ActionCreator.syncBitcoinChart()
    }
}
