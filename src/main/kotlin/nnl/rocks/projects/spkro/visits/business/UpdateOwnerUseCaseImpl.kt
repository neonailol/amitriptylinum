package nnl.rocks.projects.spkro.visits

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateVisitUseCaseImpl(
    private val repository: VisitEntityRepository
) : UpdateVisitUseCase {

    override fun invoke(
        id: UUID,
        command: UpdateVisitCommand
    ) {
        val entity = repository.getOne(id)
        repository.save(entity)
    }
}
