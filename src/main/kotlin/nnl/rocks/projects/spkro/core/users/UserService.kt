package nnl.rocks.projects.spkro.core.users

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service("userDetailsService")
class UserService(
    private val repository: UserEntityRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails = repository.findOneByUsername(username)
}
