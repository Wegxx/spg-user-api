package com.tcc.spg.user.api.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "scheduled_class")
data class ScheduledClass (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "avaliable_time_id")
    var avaliableTime: AvaliableTime? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    var subject: Subject? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    var classGroup: ClassGroup? = null,

    @Column(name = "date")
    var date: LocalDate? = null
)

