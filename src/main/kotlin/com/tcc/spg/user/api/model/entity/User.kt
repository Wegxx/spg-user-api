package com.tcc.spg.user.api.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
@Data
class User: UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(unique = true, name = "login")
    var login: String? = ""

    @Column(name = "password")
    var password: String? = ""

    @JsonBackReference
    @OneToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
    var person: Person? = null

    @ManyToMany
    var roles: MutableList<Role> = mutableListOf()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val finalRoles = mutableListOf<SimpleGrantedAuthority>()
        this.roles.forEach {
            finalRoles.add(SimpleGrantedAuthority("ROLE_" + it.name))
        }
        return finalRoles
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }
}

