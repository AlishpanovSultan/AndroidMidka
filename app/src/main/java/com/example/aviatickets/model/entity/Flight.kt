package com.example.aviatickets.model.entity

/**
 * think about json deserialization considering its snake_case format
 */
data class Flight(
    val departure_location: Location,
    val arrival_location: Location,
    val departure_time_info: String,
    val arrival_time_info: String,
    val flight_number: String,
    val airline: Airline,
    val duration: Int
)