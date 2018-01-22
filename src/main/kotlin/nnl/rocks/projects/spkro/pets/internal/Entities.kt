package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.owners.OwnerEntity
import org.hibernate.validator.constraints.NotBlank
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.validation.constraints.NotNull

@Entity
data class PetEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String,

    @field:NotNull
    var birthday: LocalDateTime,

    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "owner_id")
    var owner: OwnerEntity,

    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "pet_type_id")
    var type: PetTypeEntity
)

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
data class PetTypeEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String
)
