package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var name: String? = "",

    @Column
    var cpf: String? = "",

    @Column
    var birthdate: LocalDate? = LocalDate.now(),

    @Column
    @OneToOne(mappedBy = "person", cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    var user: User
)

