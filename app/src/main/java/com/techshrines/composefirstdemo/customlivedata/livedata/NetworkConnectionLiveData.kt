package com.techshrines.composefirstdemo.customlivedata.livedata

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class NetworkConnectionLiveData(context: Context): LiveData<Boolean>() {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }

    // 1. Triggered when an active lifecycle owner start observing
    override fun onActive() {
        super.onActive()

        // Push the initial network state immediately
        val activeNetwork = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        val isConnected = capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        value = isConnected

        // Register the network listener
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)


    }

    // 2. Triggers when no active Lifecycle Owners are listing anymore
    override fun onInactive() {
        super.onInactive()
        // Unregister to avoid memory leaks
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}