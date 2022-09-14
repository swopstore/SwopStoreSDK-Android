package com.swopstore.sdk.view

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import com.swopstore.sdk.models.Banner

  class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {


    init {
        settings.javaScriptEnabled = true
        settings.useWideViewPort = true
    }

    override fun canScrollVertically(direction: Int): Boolean {
        return false
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return false
    }

     fun showBanner(banner: Banner?, scale: Double=1.0) {
        val string = banner?.getScript(scale) ?: ""
        loadDataWithBaseURL("https://swopstore.com",string, "text/html", "UTF-8",null)
    }

  
     private fun showDebugBanner(banner: Banner?, scale: Double=1.0){
        val string = banner?.getDebugScript(scale) ?: ""
        loadData(string, "text/html", "UTF-8")
    }


}