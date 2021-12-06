package com.example.tastebuds.ui.review

import com.google.firebase.auth.FirebaseUser
import java.time.LocalDateTime
import java.util.*

class Review (restaurant: String, location: String, title: String, rating: Double, review: String, userId: String, date: LocalDateTime) {
    private var restaurant: String? = null
    private var location: String? = null
    private var title: String? = null
    private var rating: Double = 0.0
    private var review: String? = null
    private var userId: String? = null
    private var date: LocalDateTime? = null

    init {
        this.restaurant = restaurant
        this.location = location
        this.title = title
        this.rating = rating
        this.review = review
        this.userId = userId
        this.date = date
    }

    fun getRestaurantName(): String {
        return restaurant.toString()
    }

    fun setRestaurantName(restaurant: String) {
        this.restaurant = restaurant
    }

    fun getLocation(): String {
        return location.toString()
    }

    fun setLocation(location: String) {
        this.location = location
    }

    fun getTitle(): String {
        return title.toString()
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getRating(): Double {
        return rating
    }

    fun setRating(rating: Double) {
        this.rating = rating
    }

    fun getReview(): String {
        return review.toString()
    }

    fun setReview(review: String) {
        this.review = review
    }

    fun getUserId(): String {
        return userId!!
    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    fun getDate(): LocalDateTime {
        return date!!
    }

    fun setDate(date: LocalDateTime) {
        this.date = date
    }
}