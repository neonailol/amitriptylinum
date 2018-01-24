package nnl.rocks.projects.spkro.visits

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetVisitUseCaseImpl(
    private val repository: VisitEntityRepository
) : GetVisitUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): VisitEntity {
        return repository.getOne(id)
    }
}
