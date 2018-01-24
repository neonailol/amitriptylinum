//TODO: Refactor specs to more general approach

package nnl.rocks.projects.spkro.visits

import nnl.rocks.projects.spkro.core.like
import org.springframework.data.jpa.domain.Specifications

fun nameContains(name: String?): Specifications<VisitEntity>? = name?.let {
    VisitEntity::name.like("%$name%")
}
