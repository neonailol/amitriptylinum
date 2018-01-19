package nnl.rocks.projects.spkro.pets

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GetPetTypesUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<PetTypeEntity>
}
