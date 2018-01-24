package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetVeterinarianUseCaseImpl(
    private val repository: VeterinarianEntityRepository
) : GetVeterinarianUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): VeterinarianEntity {
        return repository.getOne(id)
    }
}
