package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var login: String? = "",

    @Column
    var password: String? = "",

    @Column
    @OneToOne(cascade = [(CascadeType.ALL)], fetch= FetchType.EAGER)
    @JoinColumn(name = "person_id")
    var person: Person
)

