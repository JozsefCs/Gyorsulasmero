package com.example.beadando1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.TextView

class SajatListener(val X: TextView,val Y: TextView,val Z: TextView, val maximum: TextView,val minimum:TextView) : SensorEventListener{

    override fun onSensorChanged(seged: SensorEvent?) {
        X.text = "${seged!!.values[0]}"
        Y.text = "${seged!!.values[1]}"
        Z.text = "${seged!!.values[2]}"

        var Max : Float = maximum.text.toString().toFloat()
        var Min : Float = minimum.text.toString().toFloat()

        if(X.text.toString().toFloat() > Max) maximum.text = X.text
        if(X.text.toString().toFloat() < Min) minimum.text = X.text

        if(Y.text.toString().toFloat() > Max) maximum.text = Y.text
        if(Y.text.toString().toFloat() < Min) minimum.text = Y.text

        if(Z.text.toString().toFloat() > Max) maximum.text = Z.text
        if(Z.text.toString().toFloat() < Min) minimum.text = Z.text

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}