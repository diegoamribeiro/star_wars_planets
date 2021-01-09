package com.diegoribeiro.star_wars.model

import javax.persistence.*

@Entity
@Table(name = "TBL_PLANET")
data class Planet(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val climate: String = "",
    val terrain: String= "",
    val life: Boolean = false
    )