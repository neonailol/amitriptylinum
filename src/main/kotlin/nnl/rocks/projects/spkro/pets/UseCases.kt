package nnl.rocks.projects.spkro.pets

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface GetPetTypesUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<PetTypeEntity>
}

interface GetPetTypeUseCase {
    operator fun invoke(
        id: UUID
    ): PetTypeEntity
}

interface DeletePetTypeUseCase {
    operator fun invoke(
        id: UUID
    )
}
