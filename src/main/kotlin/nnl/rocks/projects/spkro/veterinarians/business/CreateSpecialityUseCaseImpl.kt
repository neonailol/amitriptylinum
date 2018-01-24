package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class CreateSpecialtyUseCaseImpl(
    private val repository: SpecialtyEntityRepository
) : CreateSpecialtyUseCase {

    @Transactional
    override fun invoke(command: CreateSpecialtyCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreateSpecialtyCommand.toEntity(): SpecialtyEntity {
    return SpecialtyEntity(UUID.randomUUID(), name)
}
