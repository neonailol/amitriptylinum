package nnl.rocks.projects.spkro.owners

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface GetOwnersUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<OwnerEntity>
}

interface GetOwnerUseCase {
    operator fun invoke(
        id: UUID
    ): OwnerEntity
}

interface DeleteOwnerUseCase {
    operator fun invoke(
        id: UUID
    )
}

interface CreateOwnerUseCase {
    operator fun invoke(
        command: CreateOwnerCommand
    ): UUID
}

interface UpdateOwnerUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdateOwnerCommand
    )
}
