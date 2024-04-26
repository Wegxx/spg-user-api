package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "studant")
data class Studant (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @JsonBackReference
    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "class_group_id")
    var classGroup: ClassGroup? = null,

    @Column(name = "name", length = 100)
    var name: String? = "",

    @Column(name = "register_code")
    var registerCode: Long? = null
)

