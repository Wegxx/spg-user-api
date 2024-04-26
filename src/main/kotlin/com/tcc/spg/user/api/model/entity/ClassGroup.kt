package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "class_group")
data class ClassGroup (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "matrix_id")
    var matrix: Matrix? = null,

    @JsonManagedReference
    @OneToMany(mappedBy = "classGroup")
    var studants: MutableList<Studant?> = mutableListOf()

)

