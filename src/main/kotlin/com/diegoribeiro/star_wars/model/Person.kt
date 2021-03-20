package com.diegoribeiro.star_wars.model

import javax.persistence.*

@Entity
@Table(name = "TBL_PERSON")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String = "",
    var birthPlanet: String = "",
    var specie: String = "",
    @Lob
    var photo: ByteArray?  = null
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (photo != null) {
            if (other.photo == null) return false
            if (!photo.contentEquals(other.photo)) return false
        } else if (other.photo != null) return false

        return true
    }

    override fun hashCode(): Int {
        return photo?.contentHashCode() ?: 0
    }
}