package com.diegoribeiro.star_wars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.servlet.http.HttpServletResponse

import javax.servlet.ServletException

import java.io.IOException

import javax.servlet.FilterChain

import javax.servlet.ServletResponse

import javax.servlet.ServletRequest

@SpringBootApplication
class StarWarsApplication

fun main(args: Array<String>) {
	runApplication<StarWarsApplication>(*args)

}

