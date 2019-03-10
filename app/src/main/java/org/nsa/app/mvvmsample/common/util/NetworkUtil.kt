package org.nsa.app.mvvmsample.common.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {

    val INET4ADDRESS = 1
    val INET6ADDRESS = 2

    // wifi 연결 여부 리턴
    fun isConnectedWifi(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo

        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                return true
            }
        }

        return false
    }

    // 3g 연결 여부 리턴
    fun isConnected3G(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo

        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                return true
            }
        }

        return false
    }

    // 인터넷 연결 여부 리턴
    fun isConnectedInternet(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo

        return activeNetwork != null
    }
}