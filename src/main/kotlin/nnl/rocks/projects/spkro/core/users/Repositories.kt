package nnl.rocks.projects.spkro.core.users

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserEntityRepository : JpaRepository<UserEntity, UUID> {
    fun findOneByUsername(username: String): UserEntity
}
