//TODO: Refactor specs to more general approach

package nnl.rocks.projects.spkro.veterinarians

import nnl.rocks.projects.spkro.core.like
import org.springframework.data.jpa.domain.Specifications

fun nameContains(name: String?): Specifications<SpecialtyEntity>? = name?.let {
    SpecialtyEntity::name.like("%$name%")
}

fun veterinarianNameContains(name: String?): Specifications<VeterinarianEntity>? = name?.let {
    VeterinarianEntity::name.like("%$name%")
}
