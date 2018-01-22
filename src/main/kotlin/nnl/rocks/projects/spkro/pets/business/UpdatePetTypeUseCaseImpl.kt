package nnl.rocks.projects.spkro.pets

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
