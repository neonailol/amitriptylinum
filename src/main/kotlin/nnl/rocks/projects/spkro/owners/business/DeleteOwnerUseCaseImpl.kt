package nnl.rocks.projects.spkro.owners

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeleteOwnerUseCaseImpl(
    private val repository: OwnerEntityRepository
) : DeleteOwnerUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
