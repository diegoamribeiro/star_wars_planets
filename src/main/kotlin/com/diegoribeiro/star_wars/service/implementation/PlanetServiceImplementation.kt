package com.diegoribeiro.star_wars.service.implementation

import com.diegoribeiro.star_wars.model.Planet
import com.diegoribeiro.star_wars.repository.PlanetRepository
import com.diegoribeiro.star_wars.service.PlanetService
import com.mysql.cj.util.Base64Decoder
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class PlanetServiceImplementation(val planetRepository: PlanetRepository) : PlanetService{

    @Cacheable("planets")
    override fun getById(id: Long): Planet? {
        return planetRepository.findById(id).orElse(null)
    }

    @CacheEvict("planets", allEntries = true)
    override fun create(planet: Planet) {
        planetRepository.save(planet)
    }


    override fun delete(id: Long) {
        planetRepository.deleteById(id)
    }

    override fun deleteMany(ids: List<Planet>) {
        planetRepository.deleteAll(ids)
    }

    override fun update(id: Long, planet: Planet) {
        create(planet)
    }

    @Cacheable("planets")
    override fun getByName(name: String): List<Planet> = planetRepository.findByName(name)

    @Cacheable("planets")
    override fun getAll(): List<Planet> {
        return planetRepository.findAll().toList()
    }

    @Cacheable("planets")
    override fun count(): Long {
        return planetRepository.count()
    }
}