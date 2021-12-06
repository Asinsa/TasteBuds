package com.example.tastebuds.ui.home

class Restaurant {
    var restaurantName: String? = null
    private var restaurantLocation: String? = null
    private var restaurantImage: Int = 0
    private var restaurantRating: Double = 0.0
    private var distance: Int = 0

    fun getNames(): String {
        return restaurantName.toString()
    }

    fun setNames(name: String) {
        this.restaurantName = name
    }

    fun getImages(): Int {
        return restaurantImage
    }

    fun setImages(image_drawable: Int) {
        this.restaurantImage = image_drawable
    }

    fun getRestaurantRating(): Double {
        return restaurantRating
    }

    fun setRestaurantRating(stars: Double) {
        this.restaurantRating = stars
    }

    fun getRestaurantDistance(): Int {
        return distance
    }

    fun setRestaurantDistance(distance: Int) {
        this.distance = distance
    }
}