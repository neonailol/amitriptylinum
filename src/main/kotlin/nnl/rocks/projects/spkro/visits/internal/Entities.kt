package nnl.rocks.projects.spkro.visits

import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

@Entity
data class VisitEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String,

    @field:NotBlank
    var address: String,

    @field:NotBlank
    @field:Digits(fraction = 0, integer = 10)
    var phone: String
)
