package br.com.flaviokreis.btcinfo.services

import br.com.flaviokreis.btcinfo.models.BitcoinChart
import br.com.flaviokreis.btcinfo.models.BitcoinStats

object BitcoinServiceApi: BaseApi() {
    private val service = retrofit.create(BitcoinService::class.java)

    fun getChart(callback: (chart: BitcoinChart?, error: String?) -> Unit) {
        service.getChartMarketPrice().enqueue(handleResponse(callback))
    }

    fun getStats(callback: (stats: BitcoinStats?, error: String?) -> Unit) {
        service.getStats().enqueue(handleResponse(callback))
    }
}