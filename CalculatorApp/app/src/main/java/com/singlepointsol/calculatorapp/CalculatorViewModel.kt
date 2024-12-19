package com.singlepointsol.calculatorapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel(){

    private val _equatonText = MutableLiveData("")
    val equationText : LiveData<String> = _equatonText

    private val  _resultText = MutableLiveData("8")
    val resultText:LiveData<String> = _resultText

    fun onButtonClick(btn: String){
        Log.i("Clicked Button",btn)

        _equatonText.value?.let {
            if(btn=="AC")
                _equatonText.value=""
        }

    }
}