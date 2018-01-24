package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeleteVeterinarianUseCaseImpl(
    private val repository: VeterinarianEntityRepository
) : DeleteVeterinarianUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
