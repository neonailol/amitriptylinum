package nnl.rocks.projects.spkro.veterinarians

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetSpecialtyUseCaseImpl(
    private val repository: SpecialtyEntityRepository
) : GetSpecialtyUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): SpecialtyEntity {
        return repository.getOne(id)
    }
}
