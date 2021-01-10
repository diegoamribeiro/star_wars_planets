package com.diegoribeiro.star_wars.controller

import com.diegoribeiro.star_wars.model.ErrorMessage
import com.diegoribeiro.star_wars.model.Planet
import com.diegoribeiro.star_wars.model.ResponseJson
import com.diegoribeiro.star_wars.service.PlanetService
import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@Suppress("UNREACHABLE_CODE")
@RestController
@RequestMapping("/planets")
class PlanetController{

    @Autowired
    lateinit var planetService: PlanetService

    @PostMapping
    fun createPlanet(@RequestBody planet: Planet): ResponseEntity<ResponseJson>{
        planetService.create(planet)
        return ResponseEntity(ResponseJson("Ok", Date()), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any>{
        val planet = planetService.getById(id)
        return if (planet != null){
            return ResponseEntity(planet, HttpStatus.OK)
        }else{
            return ResponseEntity(ErrorMessage("PLANET NOT FOUND!", "Planet $id"), HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updatePlanet(@Validated @PathVariable id: Long, @RequestBody planet: Planet): ResponseEntity<Unit>{
        planetService.update(id, planet)
        var status = HttpStatus.NOT_FOUND
        if (planetService.getById(id) != null){
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @DeleteMapping("/{id}")
    fun deletePlanet(@PathVariable id: Long): ResponseEntity<Unit>{
        var status = HttpStatus.NOT_FOUND
        if (planetService.getById(id) != null){
            planetService.delete(id)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping
    fun getAllPlanets(): ResponseEntity<List<Planet>>{
        val list = planetService.getAll()
        val status = if (list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list, status)
    }

    @GetMapping("names")
    fun getPlanetByName(@RequestParam(required = false, defaultValue = " ") nameFilter: String): ResponseEntity<List<Planet>>{
        val filtered = planetService.getByName(nameFilter)
        val status = if (filtered.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(filtered, status)
    }










}