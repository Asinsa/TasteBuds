package com.example.tastebuds.ui.account

class User(userId: String, displayName: String, firstName: String, lastName: String) {
    var email: String? = null
    private var displayName: String? = null
    private var firstName: String? = null
    private var lastName: String? = null

    init {
        this.email = userId
        this.displayName = displayName
        this.firstName = firstName.capitalize()
        this.lastName = lastName.capitalize()
    }

    @JvmName("getEmail1")
    fun getEmail(): String {
        return email.toString()
    }

    @JvmName("setEmail1")
    fun setEmail(email: String) {
        this.email = email
    }

    fun getDisplayName(): String {
        return displayName.toString()
    }

    fun setDisplayName(displayName: String) {
        this.displayName = displayName
    }

    fun getFirstName(): String {
        return firstName.toString()
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getLastName(): String {
        return lastName.toString()
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }
}