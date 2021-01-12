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
    val life: Boolean = false,

    @Lob
    var photo: ByteArray? = null
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Planet

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