package nnl.rocks.projects.spkro.visits

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface GetVisitsUseCase {
    operator fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<VisitEntity>
}

interface GetVisitUseCase {
    operator fun invoke(
        id: UUID
    ): VisitEntity
}

interface DeleteVisitUseCase {
    operator fun invoke(
        id: UUID
    )
}

interface CreateVisitUseCase {
    operator fun invoke(
        command: CreateVisitCommand
    ): UUID
}

interface UpdateVisitUseCase {
    operator fun invoke(
        id: UUID,
        command: UpdateVisitCommand
    )
}
