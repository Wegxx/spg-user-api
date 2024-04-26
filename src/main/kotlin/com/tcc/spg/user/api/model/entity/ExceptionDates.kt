package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "exception_dates")
data class ExceptionDates (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "avaliable_time_id")
    var avaliableTime: AvaliableTime? = null,

    @Column(name = "date")
    var date: LocalDate? = null,

    @Column(name = "description", length = 200)
    var description: String? = null
)

