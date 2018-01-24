package nnl.rocks.projects.spkro.veterinarians

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface GetSpecialtiesUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<SpecialtyEntity>
}

interface GetSpecialtyUseCase {
    operator fun invoke(
        id: UUID
    ): SpecialtyEntity
}

interface DeleteSpecialtyUseCase {
    operator fun invoke(
        id: UUID
    )
}

interface CreateSpecialtyUseCase {
    operator fun invoke(
        command: CreateSpecialtyCommand
    ): UUID
}

interface UpdateSpecialtyUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdateSpecialtyCommand
    )
}

interface GetVeterinariansUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<VeterinarianEntity>
}

interface GetVeterinarianUseCase {
    operator fun invoke(
        id: UUID
    ): VeterinarianEntity
}

interface DeleteVeterinarianUseCase {
    operator fun invoke(
        id: UUID
    )
}

interface CreateVeterinarianUseCase {
    operator fun invoke(
        command: CreateVeterinarianCommand
    ): UUID
}

interface UpdateVeterinarianUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdateVeterinarianCommand
    )
}
