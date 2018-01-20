package nnl.rocks.projects.spkro.pets.business

import nnl.rocks.projects.spkro.pets.CreatePetTypeCommand
import nnl.rocks.projects.spkro.pets.CreatePetTypeUseCase
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class CreatePetTypeUseCaseImpl(
    private val repository: PetTypeEntityRepository
) : CreatePetTypeUseCase {

    @Transactional
    override fun invoke(command: CreatePetTypeCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreatePetTypeCommand.toEntity(): PetTypeEntity {
    return PetTypeEntity(UUID.randomUUID(), name)
}
