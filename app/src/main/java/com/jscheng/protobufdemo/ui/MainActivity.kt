package com.jscheng.protobufdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jscheng.protobufdemo.R
import com.jscheng.protobufdemo.proto.PersonProtoBuffer
import java.lang.StringBuilder
import kotlin.experimental.and

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peter = PersonProtoBuffer.Person
            .newBuilder()
            .setName("peter")
            .build()

        val data = peter.toByteArray()
        val stringBuilder = StringBuilder()

        for (b in data) {
            stringBuilder.append(String.format("%02x", (b and 0xff.toByte())))
        }
        Log.d(TAG, stringBuilder.toString())

        val copyPeter = PersonProtoBuffer.Person.parseFrom(data)

        Log.d(TAG, copyPeter.name)
    }
}
