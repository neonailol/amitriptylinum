package nnl.rocks.projects.spkro.pets.business

import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import nnl.rocks.projects.spkro.pets.UpdatePetTypeCommand
import nnl.rocks.projects.spkro.pets.UpdatePetTypeUseCase
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdatePetTypeUseCaseImpl(
    private val repository: PetTypeEntityRepository
) : UpdatePetTypeUseCase {

    override fun invoke(
        id: UUID,
        command: UpdatePetTypeCommand
    ) {
        val entity = repository.getOne(id)
        entity.name = command.name
        repository.save(entity)
    }
}
