package br.com.flaviokreis.btcinfo.services

import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.models.BitcoinStats
import retrofit2.Call
import retrofit2.http.GET

interface BitcoinService {

    @GET("/charts/market-price?timespan=1year&daysAverageString=7")
    fun getChartMarketPrice(): Call<BitcoinChart>

    @GET("/stats")
    fun getStats(): Call<BitcoinStats>
}