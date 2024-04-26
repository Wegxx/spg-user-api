package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "teacher")
data class Teacher (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    var person: Person
)

