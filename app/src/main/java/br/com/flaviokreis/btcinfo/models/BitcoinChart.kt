package br.com.flaviokreis.btcinfo.models

import br.com.flaviokreis.btcinfo.models.converters.BitcoinChartValuesConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class BitcoinChart(
    @Id(assignable = true) var _id: Long = 1,

    val status: String = "",
    val name: String = "",
    val unit: String = "",
    val period: String = "",
    val description: String = "",

    @Convert(converter = BitcoinChartValuesConverter::class, dbType = String::class)
    val values: BitcoinChartValues = BitcoinChartValues()
)