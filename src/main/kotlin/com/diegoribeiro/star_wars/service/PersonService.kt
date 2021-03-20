package com.diegoribeiro.star_wars.service

import com.diegoribeiro.star_wars.model.Person

interface PersonService{
    fun findByid(id: Long): Person
    fun save(person: Person)
    fun delete(id: Long)
    fun deleteMany(ids: List<Person>)
    fun update(id: Long, person:Person)
    fun findByName(name: String):List<Person>
    fun findAll(): List<Person>
    fun count(): Long
}