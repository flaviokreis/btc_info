package br.com.flaviokreis.btcinfo.models.converters

import br.com.flaviokreis.btcinfo.models.BitcoinChartValues
import com.google.gson.Gson
import io.objectbox.converter.PropertyConverter

class BitcoinChartValuesConverter : PropertyConverter<BitcoinChartValues, String> {
    override fun convertToDatabaseValue(entityProperty: BitcoinChartValues?): String {
        if (entityProperty == null) return ""

        return Gson().toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String?): BitcoinChartValues {
        if (databaseValue == null) return BitcoinChartValues()

        return Gson().fromJson(databaseValue, BitcoinChartValues::class.java)
    }

}