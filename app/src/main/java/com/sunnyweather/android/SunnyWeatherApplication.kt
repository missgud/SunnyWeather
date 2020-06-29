package com.sunnyweather.android

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class SunnyWeatherApplication : Application() {

    companion object {
        const val TOKEN = "t2Xf6YzzmzbfsTdE"

        private lateinit var context: Context

        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val strategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // 是否显示线程信息，默认为ture
            .methodCount(1)         // 显示的方法行数
            .methodOffset(0)        // 隐藏内部方法调用到偏移量
            .tag("tag")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(strategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}