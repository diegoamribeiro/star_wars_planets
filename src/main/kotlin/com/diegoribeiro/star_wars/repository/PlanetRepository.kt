package com.diegoribeiro.star_wars.repository

import com.diegoribeiro.star_wars.model.Planet
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface PlanetRepository : PagingAndSortingRepository<Planet, Long>{

    @Query(value = "SELECT planet FROM Planet planet WHERE planet.name LIKE :name% ORDER BY planet.name ASC")
    fun findByName(@Param("name") name: String): List<Planet>

}