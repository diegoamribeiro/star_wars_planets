package com.diegoribeiro.star_wars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarWarsApplication

fun main(args: Array<String>) {
	runApplication<StarWarsApplication>(*args)
}
