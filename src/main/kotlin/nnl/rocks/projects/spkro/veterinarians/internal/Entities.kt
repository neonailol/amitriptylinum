package nnl.rocks.projects.spkro.veterinarians

import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.validation.constraints.NotNull

@Entity
data class VeterinarianEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String,

    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "veterinarian_specialty_id")
    var specialty: SpecialtyEntity
)

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
data class SpecialtyEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String
)
