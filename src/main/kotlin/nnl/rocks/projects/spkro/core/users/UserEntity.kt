package nnl.rocks.projects.spkro.core.users

import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotBlank
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "users")
class UserEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
    val id: UUID,

    @field:NotBlank
    private val username: String,

    @field:NotBlank
    private var password: String

) : UserDetails {

    override fun getUsername(): String = username

    override fun getPassword(): String = password

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun isEnabled(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

}
