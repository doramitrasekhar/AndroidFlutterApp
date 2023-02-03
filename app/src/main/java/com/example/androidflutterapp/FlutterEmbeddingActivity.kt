package com.example.androidflutterapp

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterEmbeddingActivity : FlutterActivity() {

    companion object {

        private var cachedFlutterEngine: FlutterEngine? = null

        fun initialiseFlutterEngine(
            context: Context,
            initialRoute: String,
            engineId: String,
        ): FlutterEngine? {
            cachedFlutterEngine = FlutterEngine(context)
            cachedFlutterEngine?.navigationChannel?.setInitialRoute(initialRoute)
            cachedFlutterEngine?.dartExecutor?.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache
                .getInstance()
                .put(engineId, cachedFlutterEngine)

            return cachedFlutterEngine
        }

        fun createBuilder(engineId: String): CachedEngineIntentBuilder? {
            return withCachedEngine(engineId)
        }
    }
}