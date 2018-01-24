package nnl.rocks.projects.spkro.owners

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class CreateOwnerUseCaseImpl(
    private val repository: OwnerEntityRepository
) : CreateOwnerUseCase {

    @Transactional
    override fun invoke(command: CreateOwnerCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreateOwnerCommand.toEntity(): OwnerEntity {
    return OwnerEntity(
        id = UUID.randomUUID(),
        name = name,
        address = "",
        phone = ""
    )
}
