package br.com.flaviokreis.btcinfo.middlewares

import android.content.Context
import br.com.flaviokreis.btcinfo.models.AppState
import br.com.flaviokreis.btcinfo.utils.NetworkUtils
import com.github.raulccabreu.redukt.middlewares.BaseAnnotatedMiddleware

abstract class NetworkOnMiddleware(private val context: Context):
    BaseAnnotatedMiddleware<AppState>(){

    override fun canExecute(state: AppState): Boolean {
        return NetworkUtils.isOnline(context)
    }

}