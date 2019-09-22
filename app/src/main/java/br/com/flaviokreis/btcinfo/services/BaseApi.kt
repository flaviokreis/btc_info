package br.com.flaviokreis.btcinfo.services

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseApi {
    protected val retrofit = Retrofit.Builder()
        .baseUrl("https://api.blockchain.info")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    protected fun <T> handleResponse(callback: (chart: T?, error: String?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.e("BitcoinServiceApi", t.localizedMessage, t)
                callback.invoke(null, t.localizedMessage)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    callback.invoke(response.body(), null)
                } else {
                    callback.invoke(null,
                        response.errorBody()?.string() ?: response.code().toString())
                }
            }
        }
    }
}