package nnl.rocks.projects.spkro.core.security

import nnl.rocks.projects.spkro.core.users.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

sealed class User(
    val id: UUID,
    private val username: String,
    private val password: String
) : UserDetails {

    constructor(user: UserEntity) : this(user.id, user.username, user.password)

    override fun getUsername(): String = username

    override fun getPassword(): String = password

    override fun getAuthorities(): MutableCollection<GrantedAuthority> = mutableListOf()

    override fun isEnabled(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}

class AdminUser(user: UserEntity) : User(user)

class OwnerUser(user: UserEntity) : User(user)

class VeterinarianUser(user: UserEntity) : User(user)
