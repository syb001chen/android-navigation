package com.example.android.codelabs.navigation

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.content.res.Resources
import android.support.annotation.NonNull

/**
 * @data  2018/6/6.
 * @author syb
 * 屏幕低成本适配方案
 * {@link https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA}
 */
class DensityHelper {
    companion object {
        private var sNoncompatDensity: Float = 0f
        private var sNoncompatScaleDensity: Float = 0f

        @JvmStatic
        fun setCustomDensity(@NonNull activity: Activity, @NonNull application: Application) {
            val appDisplayMetrics = application.resources.displayMetrics

            if (sNoncompatDensity == 0f) {
                sNoncompatDensity = appDisplayMetrics.density;
                sNoncompatScaleDensity = appDisplayMetrics.scaledDensity
                application.registerComponentCallbacks(object : ComponentCallbacks {

                    override fun onLowMemory() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onConfigurationChanged(newConfig: Configuration?) {
                        if (newConfig != null && newConfig.fontScale > 0) {
                            sNoncompatScaleDensity = Resources.getSystem().displayMetrics.scaledDensity
                        }
                    }
                })
            }

            val targetDensity: Float = (Resources.getSystem().displayMetrics.widthPixels / 360).toFloat()
            val targetScaleDensity: Float = targetDensity * (sNoncompatScaleDensity / sNoncompatDensity)
            val targetDensityDpi: Int = (160 * targetDensity).toInt()

            appDisplayMetrics.density = targetDensity
            appDisplayMetrics.scaledDensity = targetScaleDensity
            appDisplayMetrics.densityDpi = targetDensityDpi

            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = targetDensity
            activityDisplayMetrics.scaledDensity = targetScaleDensity
            activityDisplayMetrics.densityDpi = targetDensityDpi
        }
    }
}