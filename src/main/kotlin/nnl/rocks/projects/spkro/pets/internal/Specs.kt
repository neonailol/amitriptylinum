//TODO: Refactor specs to more general approach

package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.core.like
import org.springframework.data.jpa.domain.Specifications

fun nameContains(name: String?): Specifications<PetTypeEntity>? = name?.let {
    PetTypeEntity::name.like("%$name%")
}

fun petNameContains(name: String?): Specifications<PetEntity>? = name?.let {
    PetEntity::name.like("%$name%")
}
