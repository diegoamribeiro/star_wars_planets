package com.diegoribeiro.star_wars

import com.diegoribeiro.star_wars.model.Planet
import com.diegoribeiro.star_wars.repository.PlanetRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.nio.file.Files

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StarWarsApplicationTests {

	@Autowired
	private lateinit var planetRepository: PlanetRepository

	@Autowired
	private lateinit var entityManager: TestEntityManager

	@Test
	fun testInsertPlanet() {
		val file = File("C:\\temp\\arquivo.csv")
		val planet = Planet()

		planet.name = file.name
		val bytesPlanet: ByteArray = Files.readAllBytes(file.toPath())
		planet.photo = bytesPlanet

		val savedPlanet:Planet = planetRepository.save(planet)


	}

}
