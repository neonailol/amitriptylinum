package nnl.rocks.projects.spkro.core.users

import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

enum class UserType { OWNER, VETERINARIAN, ADMIN }

@Entity
@Table(name = "users")
class UserEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
    val id: UUID,

    @field:NotBlank
    val username: String,

    @field:NotBlank
    var password: String,

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    val type: UserType

)
