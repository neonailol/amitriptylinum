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

interface CreatePetTypeUseCase {
    operator fun invoke(
        command: CreatePetTypeCommand
    ): UUID
}

interface UpdatePetTypeUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdatePetTypeCommand
    )
}

interface GetPetsUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<PetEntity>
}

interface GetPetUseCase {
    operator fun invoke(
        id: UUID
    ): PetEntity
}

interface DeletePetUseCase {
    operator fun invoke(
        id: UUID
    )
}

interface CreatePetUseCase {
    operator fun invoke(
        command: CreatePetCommand
    ): UUID
}

interface UpdatePetUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdatePetCommand
    )
}
