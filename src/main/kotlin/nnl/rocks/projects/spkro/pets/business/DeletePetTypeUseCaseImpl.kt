package nnl.rocks.projects.spkro.pets.business

import nnl.rocks.projects.spkro.pets.DeletePetTypeUseCase
import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class DeletePetTypeUseCaseImpl(
    private val repository: PetTypeEntityRepository
) : DeletePetTypeUseCase {

    @Transactional
    override fun invoke(id: UUID) {
        repository.delete(id)
    }
}
