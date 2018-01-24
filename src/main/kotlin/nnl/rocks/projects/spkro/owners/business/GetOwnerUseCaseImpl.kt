package nnl.rocks.projects.spkro.owners

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetOwnerUseCaseImpl(
    private val repository: OwnerEntityRepository
) : GetOwnerUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): OwnerEntity {
        return repository.getOne(id)
    }
}
