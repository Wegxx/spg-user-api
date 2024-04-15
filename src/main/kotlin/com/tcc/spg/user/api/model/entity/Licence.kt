package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "licence")
data class Licence (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    var name: String? = "",

)

