package com.diegoribeiro.star_wars.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TBL_PICTURE")
data class Picture(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(length = 512, nullable = false, unique = true)
    val name: String,

    val size: Int,

    @Column(name = "upload_time")
    val uploadTime: Date,
    
    val content: Byte
)