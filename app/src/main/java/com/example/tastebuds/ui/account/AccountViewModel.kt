package com.example.tastebuds.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

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

    private val _user = MutableLiveData<FirebaseUser>(null)
    val user: LiveData<FirebaseUser> = _user

    private val _userObj = MutableLiveData<User>(null)
    val userObj: LiveData<User> = _userObj

    fun setUserObj(userObj: User) {
        _userObj.value = userObj
    }

    fun getUserObj(): User {
        return _userObj.value!!
    }

    fun setUser(user: FirebaseUser) {
        _user.value = user
    }

    fun getUser(): FirebaseUser {
        return _user.value!!
    }

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
