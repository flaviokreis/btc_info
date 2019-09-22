package br.com.flaviokreis.btcinfo.models

import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class BitcoinStats(
    @Id(assignable = true) var _id: Long = 1,

    @SerializedName("market_price_usd")
    val marketPriceUsd: Double = 0.0,

    @SerializedName("hash_rate")
    val hashRate: Double = 0.0,

    @SerializedName("total_fees_btc")
    val totalFeesBtc: Double = 0.0,

    @SerializedName("n_btc_mined")
    val nBtcMined: Double = 0.0,

    @SerializedName("n_tx")
    val nTx: Int = 0,

    @SerializedName("n_blocks_mined")
    val nBlocksMined: Int = 0,

    @SerializedName("minutes_between_blocks")
    val minutesBetweenBlocks: Double = 0.0,

    @SerializedName("totalbc")
    val totalbc: Double = 0.0,

    @SerializedName("n_blocks_total")
    val nBlocksTotal: Int = 0,

    @SerializedName("estimated_transaction_volume_usd")
    val estimatedTransactionVolumeUsd: Double = 0.0,

    @SerializedName("blocks_size")
    val blocksSize: Int = 0,

    @SerializedName("miners_revenue_usd")
    val minersRevenueUsd: Double = 0.0,

    @SerializedName("nexttretarget")
    val nextTreTarget: Int = 0,

    @SerializedName("difficulty")
    val difficulty: Double = 0.0,

    @SerializedName("estimated_btc_sent")
    val estimatedBtcSent: Double = 0.0,

    @SerializedName("miners_revenue_btc")
    val minersRevenueBtc: Double = 0.0,

    @SerializedName("total_btc_sent")
    val totalBtcSent: Double = 0.0,

    @SerializedName("trade_volume_btc")
    val tradeVolumeBtc: Double = 0.0,

    @SerializedName("trade_volume_usd")
    val tradeVolumeUsd: Double = 0.0,

    @SerializedName("timestamp")
    val timestamp: Double = 0.0
)