package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.owners.OwnerEntity
import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotBlank
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "pets")
data class PetEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
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
@Table(name = "pet_types")
data class PetTypeEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
    val id: UUID,

    @field:NotBlank
    var name: String
)
