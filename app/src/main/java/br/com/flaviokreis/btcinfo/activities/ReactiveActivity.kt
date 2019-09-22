package br.com.flaviokreis.btcinfo.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.flaviokreis.btcinfo.BitcoinApplication
import br.com.flaviokreis.btcinfo.models.AppState
import com.github.raulccabreu.redukt.states.StateListener

abstract class ReactiveActivity: AppCompatActivity(), StateListener<AppState> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(render())

        initialState()
    }

    override fun onStart() {
        super.onStart()
        BitcoinApplication.redukt.listeners.add(this)
    }

    override fun onStop() {
        BitcoinApplication.redukt.listeners.remove(this)
        super.onStop()
    }

    abstract fun initialState()

    abstract fun render(): View

}