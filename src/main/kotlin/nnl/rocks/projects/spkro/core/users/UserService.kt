package nnl.rocks.projects.spkro.core.users

import nnl.rocks.projects.spkro.core.security.AdminUser
import nnl.rocks.projects.spkro.core.security.OwnerUser
import nnl.rocks.projects.spkro.core.security.VeterinarianUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service("userDetailsService")
class UserService(
    private val repository: UserEntityRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val entity = repository.findOneByUsername(username)
        return when(entity.type) {
            UserType.ADMIN -> AdminUser(entity)
            UserType.OWNER -> OwnerUser(entity)
            UserType.VETERINARIAN -> VeterinarianUser(entity)
        }
    }
}
