package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
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
        specialty = mutableSetOf(SpecialtyEntity(UUID.randomUUID(), name))
    )
}
