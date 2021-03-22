package com.diegoribeiro.star_wars.controller

import com.diegoribeiro.star_wars.model.Person
import com.diegoribeiro.star_wars.model.ResponseJson
import com.diegoribeiro.star_wars.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*


@Suppress("SENSELESS_COMPARISON")
@RestController
@RequestMapping("/persons")
class PersonController {
    @Autowired
    lateinit var personService: PersonService

    @PostMapping
    fun savePerson(@RequestParam("name") name: String,
                   @RequestParam("birthplanet") birthPlanet: String,
                   @RequestParam("specie")  specie: String,
                   @RequestParam("photo") multipartFile: MultipartFile): ResponseEntity<ResponseJson>{

        val person = Person()

        with(person){
            this.name = name
            this.birthPlanet = birthPlanet
            this.specie = specie
            this.photo = multipartFile.fileToByteArray()
        }
        personService.save(person)
        return ResponseEntity(ResponseJson("Ok", Date()), HttpStatus.CREATED)
    }

    @CrossOrigin
    @GetMapping
    fun getAllPersons(): ResponseEntity<List<Person>>{
        val list = personService.findAll()
        val status = if (list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list, status)
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: Long): ResponseEntity<Person>{
        val person = personService.findByid(id)
        if (person != null){
            return ResponseEntity(person, HttpStatus.OK)
        }else{
            return ResponseEntity(person, HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Long, @RequestParam("name") name: String,
                     @RequestParam("birthplanet") birthPlanet: String,
                     @RequestParam("specie")  specie: String,
                     @RequestParam("photo") multipartFile: MultipartFile): ResponseEntity<ResponseJson>{

        var status = HttpStatus.NOT_FOUND
        val  newPerson = personService.findByid(id)

        newPerson.name = name
        newPerson.birthPlanet = birthPlanet
        newPerson.specie = specie
        newPerson.photo = multipartFile.fileToByteArray()
        status = HttpStatus.ACCEPTED

        personService.update(id, newPerson)
        return ResponseEntity(ResponseJson("The person ${newPerson.name} has been updated", Date()), status)
}


    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: Long): ResponseEntity<Unit>{
        var status = HttpStatus.NOT_FOUND
        if (personService.findByid(id) != null){
            personService.delete(id)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping("count")
    fun getCount(): Long{
        return personService.count()
    }

    fun MultipartFile.fileToByteArray() = this.bytes

//    fun updateData(id: Long, newPerson: Person){
//        var oldPerson = personService.findByid(id)
//        newPerson.name = oldPerson.name
//        newPerson.birthPlanet = oldPerson.birthPlanet
//        newPerson.specie = oldPerson.specie
//        newPerson.photo = oldPerson.photo
//    }

}

