package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.owners.OwnerEntity
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.UUID

@Component
class CreatePetUseCaseImpl(
    private val repository: PetEntityRepository
) : CreatePetUseCase {

    @Transactional
    override fun invoke(command: CreatePetCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreatePetCommand.toEntity(): PetEntity {
    return PetEntity(
        id = UUID.randomUUID(),
        name = name,
        birthday = LocalDateTime.now(),
        type = PetTypeEntity(UUID.randomUUID(), name),
        owner = OwnerEntity(UUID.randomUUID(), "1", "2", "3")
    )
}
