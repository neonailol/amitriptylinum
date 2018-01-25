package nnl.rocks.projects.spkro.veterinarians

import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
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

    @field:ManyToMany(fetch = FetchType.EAGER)
    @field:JoinTable(
        name = "veterinarian_specialties",
        joinColumns = [(JoinColumn(name = "veterinarian_id"))],
        inverseJoinColumns = [(JoinColumn(name = "specialty_id"))]
    )
    var specialty: MutableSet<SpecialtyEntity> = HashSet()
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
