package com.tcc.spg.user.api.infix

import com.tcc.spg.user.api.model.entity.*
import com.tcc.spg.user.api.model.vo.avaliableTime.AvaliableTimeVO
import com.tcc.spg.user.api.model.vo.avaliableTime.TimeVO
import com.tcc.spg.user.api.model.vo.classGroup.ClassGroupVO
import com.tcc.spg.user.api.model.vo.coordenador.CoordenadorVO
import com.tcc.spg.user.api.model.vo.exceptionDate.ExceptionDateVO
import com.tcc.spg.user.api.model.vo.matrix.MatrixVO
import com.tcc.spg.user.api.model.vo.scheduledClass.ScheduledClassSubjectVO
import com.tcc.spg.user.api.model.vo.scheduledClass.ScheduledClassVO
import com.tcc.spg.user.api.model.vo.specialization.SpecializationMatrixVO
import com.tcc.spg.user.api.model.vo.specialization.SpecializationVO
import com.tcc.spg.user.api.model.vo.subject.SubjectVO
import com.tcc.spg.user.api.model.vo.teacher.TeacherVO

fun AvaliableTime.toVO(): AvaliableTimeVO {
    return AvaliableTimeVO(
        id = this.id,
        teacher = this.teacher?.toVO(),
        time = this.time?.let { TimeVO(it.name, "${it.startTime} - ${it.endTime}") },
        weekDay = this.weekDay
    )
}

fun Teacher.toVO(): TeacherVO {
    return TeacherVO(
        id = this.id,
        name = this.person.name,
        personId = this.person.id,
        login = this.person.user.login
    )
}

fun ClassGroup.toVO(): ClassGroupVO {
    return ClassGroupVO(
        id = this.id,
        matrix = this.matrix?.toVO(),
        studants = this.studants
    )
}

fun Matrix.toVO(): MatrixVO {
    return MatrixVO(
        id = this.id,
        name = this.name,
        specializationName = this.specialization?.name,
        subjects = this.subjects.map {it.toVO()}.toMutableList()
    )
}

fun Subject.toVO(): SubjectVO {
    return SubjectVO(
        id = this.id,
        name = this.name,
        hours = this.hours,
        teacher = this.teacher?.toVO(),
        matrixId = this.matrix?.id
    )
}

fun Coordenador.toVO(): CoordenadorVO {
    return CoordenadorVO(
        id = this.id,
        name = this.person.name,
        personId = this.person.id,
        login = this.person.user.login
    )
}

fun ExceptionDates.toVO(): ExceptionDateVO {
    return ExceptionDateVO(
        id = this.id,
        avaliableTime = this.avaliableTime?.toVO(),
        date = this.date,
        description = this.description

    )
}

fun ScheduledClass.toVO(): ScheduledClassVO {
    return ScheduledClassVO(
        id = this.id,
        avaliableTime = this.avaliableTime?.toVO(),
        subject = this.subject?.toScheduledClassSubjectVO(),
        classGroup = this.classGroup?.toVO()
    )
}

fun Subject.toScheduledClassSubjectVO(): ScheduledClassSubjectVO {
    return ScheduledClassSubjectVO(
        id = this.id,
        name = this.name,
    )
}

fun Specialization.toVO(): SpecializationVO {
    return SpecializationVO(
        id = this.id,
        name = this.name,
        coordenador = this.coordenador?.toVO(),
        matrixes = this.matrixes.map {it.toSpecializationMatrixVO()}.toMutableList()
    )
}

fun Matrix.toSpecializationMatrixVO(): SpecializationMatrixVO {
    return SpecializationMatrixVO(
        id = this.id,
        name = this.name
    )
}
