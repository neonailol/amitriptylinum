package nnl.rocks.projects.spkro.veterinarians

import nnl.rocks.projects.spkro.owners.OwnerEntity
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.UUID

@Component
class CreateVeterinarianUseCaseImpl(
    private val repository: VeterinarianEntityRepository
) : CreateVeterinarianUseCase {

    @Transactional
    override fun invoke(command: CreateVeterinarianCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreateVeterinarianCommand.toEntity(): VeterinarianEntity {
    return VeterinarianEntity(
        id = UUID.randomUUID(),
        name = name,
        birthday = LocalDateTime.now(),
        specialty = SpecialtyEntity(UUID.randomUUID(), name),
        owner = OwnerEntity(UUID.randomUUID(), "1", "2", "3")
    )
}
