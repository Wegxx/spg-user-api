package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "persons")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    var name: String? = "",

    @Column(name = "cpf")
    var cpf: String? = "",

    @Column(name = "birthdate")
    var birthdate: LocalDate? = LocalDate.now(),

    @JsonManagedReference
    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "person")
    var user: User
)

