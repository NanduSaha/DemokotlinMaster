package com.app.kotlindemo.utils

import android.content.Context
import android.net.ConnectivityManager
import india.chat.demokotlin.di.components.ActivityComponent

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}// This utility class is not publicly instantiable

private fun ActivityComponent?.getSystemService(connectivitY_SERVICE: String): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
