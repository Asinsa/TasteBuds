package com.example.tastebuds.ui.account

class User(userId: String, displayName: String, firstName: String, lastName: String) {
    private var email: String? = null
    private var displayName: String? = null
    private var firstName: String? = null
    private var lastName: String? = null

    init {
        this.email = userId
        this.displayName = displayName
        this.firstName = firstName.capitalize()
        this.lastName = lastName.capitalize()
    }

    fun getUserId(): String {
        return email.toString()
    }

    fun setUserId(email: String) {
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