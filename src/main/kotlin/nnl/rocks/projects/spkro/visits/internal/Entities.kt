package nnl.rocks.projects.spkro.visits

import nnl.rocks.projects.spkro.pets.PetEntity
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
@Table(name = "visits")
data class VisitEntity(

    @field:Id
    @field:NotNull
    @field:Type(type = "uuid-char")
    val id: UUID,

    @field:NotNull
    var date: LocalDateTime,

    @field:NotBlank
    var description: String,

    @field:NotNull
    @field:ManyToOne
    @field:JoinColumn(name = "pet_id")
    var pet: PetEntity
)
