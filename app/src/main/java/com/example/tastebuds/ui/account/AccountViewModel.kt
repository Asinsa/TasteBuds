package com.example.tastebuds.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {
    //private val _quantity = MutableLiveData<Int>(0)
    //val quantity: LiveData<Int> = _quantity

    //private val _date = MutableLiveData<String>("")
    //val date: LiveData<String> = _date

    //private val _price = MutableLiveData<Double>(0.0)
    //val price: LiveData<Double> = _price

    private val _email = MutableLiveData<String>("")
    val email: LiveData<String> = _email

    private val _loggedIn = MutableLiveData<Boolean>(false)
    val loggedIn: LiveData<Boolean> = _loggedIn

    fun setEmail(email: String){
        _email.value = email
    }

    fun logIn(){
        _loggedIn.value = true
    }

    fun getEmail(): String {
        return _email.value.toString()
    }

    fun loggedIn(): Boolean {
        return _loggedIn.value!!
    }
}
