//TODO: Refactor specs to more general approach

package nnl.rocks.projects.spkro.owners

import nnl.rocks.projects.spkro.core.like
import org.springframework.data.jpa.domain.Specifications

fun nameContains(name: String?): Specifications<OwnerEntity>? = name?.let {
    OwnerEntity::name.like("%$name%")
}
