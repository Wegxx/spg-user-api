package com.tcc.spg.user.api.model.dto

data class AddUserRolesDTO(
    var idUser: Long,
    var idsRoles: MutableList<Long>
)