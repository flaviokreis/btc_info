package br.com.flaviokreis.btcinfo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.flaviokreis.btcinfo.services.BitcoinServiceApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BitcoinServiceApi.getChart { chart, error ->
            println("Chart: $chart")
            println("Chart error: $error")
        }

        BitcoinServiceApi.getStats { stats, error ->
            println("Stats: $stats")
            println("Stats error: $error")
        }
    }
}
