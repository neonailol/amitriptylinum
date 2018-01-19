package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.owners.OwnerEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity
data class PetEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "owner_id")
    var owner: OwnerEntity
)
