package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "matrix")
data class Matrix (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", unique = true)
    var name: String? = "",

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "specialization_id")
    var specialization: Specialization? = null,

    @JsonBackReference
    @OneToMany(mappedBy="matrix")
    var subjects: MutableList<Subject> = mutableListOf()
)

