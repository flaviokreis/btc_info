package br.com.flaviokreis.btcinfo

import android.app.Application
import android.content.Context
import br.com.flaviokreis.btcinfo.middlewares.BitcoinChartMiddleware
import br.com.flaviokreis.btcinfo.middlewares.BitcoinStatsMiddleware
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.reducers.BitcoinChartReducer
import br.com.flaviokreis.btcinfo.reducers.BitcoinStatsReducer
import com.github.raulccabreu.redukt.Redukt

class BitcoinApplication : Application() {

    companion object {
        lateinit var redukt: Redukt<AppState>
    }

    private fun initRedukt(context: Context, appState: AppState): Redukt<AppState> {
        val redukt = Redukt(appState, true)

        addReducers(redukt)
        addMiddlewares(context, redukt)

        return redukt
    }

    private fun addReducers(redukt: Redukt<AppState>) {
        redukt.reducers["bitcoin_stats_reducer"] = BitcoinStatsReducer()
        redukt.reducers["bitcoin_chart_reducer"] = BitcoinChartReducer()
    }

    private fun addMiddlewares(context: Context, redukt: Redukt<AppState>) {
        redukt.middlewares["bitcoin_stats_middleware"] = BitcoinStatsMiddleware(context)
        redukt.middlewares["bitcoin_chart_middlewre"] = BitcoinChartMiddleware(context)
    }

    override fun onCreate() {
        super.onCreate()

        initRedukt(this, AppState(stateStarted = false)).let {
            redukt = it
        }
    }

}