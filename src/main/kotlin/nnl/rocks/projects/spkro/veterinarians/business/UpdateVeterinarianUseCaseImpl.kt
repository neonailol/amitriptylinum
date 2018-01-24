package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateVeterinarianUseCaseImpl(
    private val repository: VeterinarianEntityRepository
) : UpdateVeterinarianUseCase {

    override fun invoke(
        id: UUID,
        command: UpdateVeterinarianCommand
    ) {
        val entity = repository.getOne(id)
        entity.name = command.name
        repository.save(entity)
    }
}
