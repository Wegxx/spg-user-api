package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "coordenador")
data class Coordenador (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    var person: Person,

    @JsonBackReference
    @OneToMany(mappedBy="coordenador")
    var specializations: MutableList<Specialization> = mutableListOf()
)

