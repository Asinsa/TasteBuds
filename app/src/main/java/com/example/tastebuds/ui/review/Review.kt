package com.example.tastebuds.ui.review

class Review (restaurant: String, location: String, title: String, rating: Double, review: String) {
    private var restaurant: String? = null
    private var location: String? = null
    private var title: String? = null
    private var rating: Double = 0.0
    private var review: String? = null

    init {
        this.restaurant = restaurant
        this.location = location
        this.title = title
        this.rating = rating
        this.review = review
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
}