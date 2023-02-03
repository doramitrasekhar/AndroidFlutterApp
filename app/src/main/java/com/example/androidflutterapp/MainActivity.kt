package com.example.androidflutterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity : AppCompatActivity() {
    private var cachedFlutterEngine: FlutterEngine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        cachedFlutterEngine =
            FlutterEmbeddingActivity.initialiseFlutterEngine(this, "flutter_route", "flutter_engine")
        super.onCreate(savedInstanceState)

        startFlutterActivity()
    }

    private fun startFlutterActivity() {
        startActivity(
            FlutterEmbeddingActivity.createBuilder
                ("flutter_engine")
                ?.destroyEngineWithActivity(true)?.build(this)
        )
    }
}