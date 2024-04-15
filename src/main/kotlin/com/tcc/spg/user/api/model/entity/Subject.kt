package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "subject")
data class Subject (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", unique = true)
    var name: String? = "",

    @Column(name = "hours")
    var hours: Long? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "matrix_id")
    var matrix: Matrix? = null

)

