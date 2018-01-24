package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateSpecialtyUseCaseImpl(
    private val repository: SpecialtyEntityRepository
) : UpdateSpecialtyUseCase {

    override fun invoke(
        id: UUID,
        command: UpdateSpecialtyCommand
    ) {
        val entity = repository.getOne(id)
        entity.name = command.name
        repository.save(entity)
    }
}
