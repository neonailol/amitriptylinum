package nnl.rocks.projects.spkro.pets

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
