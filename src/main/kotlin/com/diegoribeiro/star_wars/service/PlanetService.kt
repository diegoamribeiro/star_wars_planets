package com.diegoribeiro.star_wars.service

import com.diegoribeiro.star_wars.model.Planet

interface PlanetService {

    fun getById(id: Long): Planet?
    fun create(planet: Planet)
    fun delete(id: Long)
    fun deleteMany(ids: List<Planet>)
    fun update(id:Long, planet: Planet)
    fun getByName(name: String): List<Planet>
    fun getAll(): List<Planet>
    fun count(): Long

}