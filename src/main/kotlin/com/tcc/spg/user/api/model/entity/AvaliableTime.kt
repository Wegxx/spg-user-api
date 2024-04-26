package com.tcc.spg.user.api.model.entity

import com.tcc.spg.user.api.enum.ClassesTimesEnum
import com.tcc.spg.user.api.enum.WeekDaysEnum
import jakarta.persistence.*

@Entity
@Table(name = "avaliable_time")
data class AvaliableTime (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    var teacher: Teacher? = null,

    @Column(name = "time")
    var time: ClassesTimesEnum? = null,

    @Column(name = "week_Day")
    var weekDay: WeekDaysEnum? = null
)

