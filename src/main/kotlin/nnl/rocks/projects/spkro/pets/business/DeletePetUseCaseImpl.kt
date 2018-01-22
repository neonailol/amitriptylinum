package nnl.rocks.projects.spkro.pets

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeletePetUseCaseImpl(
    private val repository: PetEntityRepository
) : DeletePetUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
