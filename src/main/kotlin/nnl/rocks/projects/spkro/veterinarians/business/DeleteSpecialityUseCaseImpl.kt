package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeleteSpecialtyUseCaseImpl(
    private val repository: SpecialtyEntityRepository
) : DeleteSpecialtyUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
