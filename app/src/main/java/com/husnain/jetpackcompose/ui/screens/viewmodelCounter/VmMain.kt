package com.husnain.jetpackcompose.ui.screens.viewmodelCounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VmMain @Inject constructor(

) : ViewModel() {
    private val _counter = MutableLiveData(0)
    val count: LiveData<Int> = _counter

    fun increment() {
        viewModelScope.launch {
            _counter.value = _counter.value?.plus(1)
        }
    }

    fun decrement() {
        viewModelScope.launch {
            val current = _counter.value ?: 0
            _counter.value = if (current > 0) current - 1 else 0
        }
    }
}