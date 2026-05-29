package com.techshrines.composefirstdemo.customlivedata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.techshrines.composefirstdemo.customlivedata.livedata.NetworkConnectionLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Expose the custom live data
    val networkStatus: LiveData<Boolean> = NetworkConnectionLiveData(application)
}