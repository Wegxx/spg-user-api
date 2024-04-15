package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "specialization")
data class Specialization (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", unique = true)
    var name: String = "",

    @JsonManagedReference
    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenador_id")
    var coordenador: Coordenador? = null,

    @JsonBackReference
    @OneToMany(mappedBy="specialization")
    var matrixes: MutableList<Matrix> = mutableListOf()
)

