package com.gurpreetsk.android_starter

import com.facebook.stetho.Stetho
import com.gurpreetsk.android_starter._di.AppComponent
import com.gurpreetsk.android_starter._di.DaggerDebugAppComponent
import com.gurpreetsk.android_starter._di.modules.AppModule

class DebugMainApplication : MainApplication() {
  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Stetho.initializeWithDefaults(this)
    }
  }

  override fun setupDependencyInjection() : AppComponent = DaggerDebugAppComponent.builder()
      .appModule(AppModule(this))
      .build()
}
