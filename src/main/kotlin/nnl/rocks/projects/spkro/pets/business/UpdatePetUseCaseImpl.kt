package nnl.rocks.projects.spkro.pets

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdatePetUseCaseImpl(
    private val repository: PetEntityRepository
) : UpdatePetUseCase {

    override fun invoke(
        id: UUID,
        command: UpdatePetCommand
    ) {
        val entity = repository.getOne(id)
        entity.name = command.name
        repository.save(entity)
    }
}
