package nnl.rocks.projects.spkro.pets.business

import nnl.rocks.projects.spkro.pets.GetPetTypeUseCase
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetPetTypeUseCaseImpl(
    private val repository: PetTypeEntityRepository
) : GetPetTypeUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): PetTypeEntity {
        return repository.getOne(id)
    }
}
