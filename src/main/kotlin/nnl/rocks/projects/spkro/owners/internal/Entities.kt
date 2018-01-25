package nnl.rocks.projects.spkro.owners

import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

@Entity
@Table(name = "owners")
data class OwnerEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
    val id: UUID,

    @field:NotBlank
    var name: String,

    @field:NotBlank
    var address: String,

    @field:NotBlank
    @field:Digits(fraction = 0, integer = 10)
    var phone: String
)
