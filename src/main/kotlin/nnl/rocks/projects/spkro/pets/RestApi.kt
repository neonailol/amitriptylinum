package nnl.rocks.projects.spkro.pets

import org.springframework.data.domain.Pageable

interface GetPetTypesResource {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): PetTypesVM
}

