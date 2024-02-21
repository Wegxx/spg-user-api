package com.tcc.spg.user.api.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(var userService: UserService): UserDetailsService  {

    override fun loadUserByUsername(username: String): UserDetails? {
        return userService.findByLogin(username)
    }

}
