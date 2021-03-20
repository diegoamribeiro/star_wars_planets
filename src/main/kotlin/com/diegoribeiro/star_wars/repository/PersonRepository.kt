package com.diegoribeiro.star_wars.repository

import com.diegoribeiro.star_wars.model.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface PersonRepository: PagingAndSortingRepository<Person, Long> {

    @Query(value = "SELECT person FROM Person person WHERE person.name LIKE :name% ORDER BY person.name ASC")
    fun getByName(@Param("name") name: String): List<Person>
}