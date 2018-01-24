package nnl.rocks.projects.spkro.visits

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeleteVisitUseCaseImpl(
    private val repository: VisitEntityRepository
) : DeleteVisitUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
