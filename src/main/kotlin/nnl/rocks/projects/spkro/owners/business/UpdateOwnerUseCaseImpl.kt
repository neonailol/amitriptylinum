package nnl.rocks.projects.spkro.owners

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateOwnerUseCaseImpl(
    private val repository: OwnerEntityRepository
) : UpdateOwnerUseCase {

    override fun invoke(
        id: UUID,
        command: UpdateOwnerCommand
    ) {
        val entity = repository.getOne(id)
        entity.name = command.name
        repository.save(entity)
    }
}
