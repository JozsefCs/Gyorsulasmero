package com.example.beadando1

import android.R.attr
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.R.attr.button
import android.hardware.*
import android.view.OrientationEventListener
import android.view.View


class MainActivity : AppCompatActivity() {

    lateinit var x: TextView
    lateinit var y: TextView
    lateinit var z: TextView
    lateinit var max: TextView
    lateinit var  min: TextView
    lateinit var sensoreEventListener: SajatListener
    lateinit var gyorsulas: Sensor
    lateinit var SajatSensore: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        x = findViewById(R.id.xt)
        y = findViewById(R.id.yt)
        z = findViewById(R.id.zt)
        max = findViewById(R.id.maximum)
        min = findViewById(R.id.minimum)


        SajatSensore = getSystemService(SENSOR_SERVICE) as SensorManager
        gyorsulas = SajatSensore.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensoreEventListener = SajatListener(findViewById(R.id.xt),findViewById(R.id.yt),findViewById(R.id.zt), findViewById(R.id.maximum), findViewById(R.id.minimum))
    }

    fun handleStartClick(view: View){
        max.setText("0")
        min.setText("0")
        SajatSensore.registerListener(sensoreEventListener, gyorsulas, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun handleStopClick(view: View){
        SajatSensore.unregisterListener(sensoreEventListener,gyorsulas)
        x.setText("X tengely")
        y.setText("Y tengely")
        z.setText("Z tengely")
        max.setText("Maximum érték")
        min.setText("Minimum érték")
    }
}