package com.diegoribeiro.star_wars.service.implementation

import com.diegoribeiro.star_wars.model.Person
import com.diegoribeiro.star_wars.repository.PersonRepository
import com.diegoribeiro.star_wars.service.PersonService
import org.springframework.stereotype.Component


@Component
class PersonServiceImplementation(val personRepository: PersonRepository) : PersonService {

    //@Cacheable("persons")
    override fun findByid(id: Long): Person {
        return personRepository.findById(id).orElse(null)
    }

    //@CacheEvict("persons", allEntries = true)
    override fun save(person: Person) {
        personRepository.save(person)
    }

    override fun delete(id: Long) {
        personRepository.deleteById(id)
    }

    override fun deleteMany(ids: List<Person>) {
        personRepository.deleteAll(ids)
    }

    override fun update(id: Long, person: Person) {
        save(person)
    }

    //@Cacheable("persons")
    override fun findByName(name: String): List<Person> {
        return personRepository.getByName(name)
    }

    //@Cacheable("persons")
    override fun findAll(): List<Person> {
        return personRepository.findAll().toList()
    }

    //@Cacheable("persons")
    override fun count(): Long {
        return personRepository.count()
    }

}