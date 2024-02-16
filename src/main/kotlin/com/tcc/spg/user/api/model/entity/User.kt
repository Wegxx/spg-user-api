package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
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

    @JsonBackReference
    @OneToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
    var person: Person? = null
)

