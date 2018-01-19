package nnl.rocks.projects.spkro.owners

import nnl.rocks.projects.spkro.pets.PetEntity
import org.hibernate.validator.constraints.NotBlank
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

@Entity
data class OwnerEntity(

    @field:Id
    @field:NotNull
    val id: UUID,

    @field:NotBlank
    var name: String,

    @field:NotBlank
    var address: String,

    @field:NotBlank
    @field:Digits(fraction = 0, integer = 10)
    var phone: String,

    @field:NotNull
    @field:OneToMany(cascade = [(CascadeType.ALL)], mappedBy = "owner")
    private val pets: MutableSet<PetEntity> = HashSet()

) {

    fun getPets(): Set<PetEntity> {
        return pets.toSet()
    }

    fun addPet(pet: PetEntity) {
        pet.owner = this
        pets += pet
    }
}
