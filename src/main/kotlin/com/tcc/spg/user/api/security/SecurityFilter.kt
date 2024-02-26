package com.tcc.spg.user.api.security

import com.tcc.spg.user.api.repository.UsersRepository
import com.tcc.spg.user.api.service.UserDetailsService
import com.tcc.spg.user.api.service.token.TokenService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(val tokenService: TokenService,
                     val usersService: UserDetailsService) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = this.recoverToken(request)
        if (token != null){
            val login = tokenService.validateToken(token)
            val user = usersService.findByLogin(login)

            val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader: String = request.getHeader("Authorization") ?: return null
        return authHeader.replace("Bearer ", "")
    }

}