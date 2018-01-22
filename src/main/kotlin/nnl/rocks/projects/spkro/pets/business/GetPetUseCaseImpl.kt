package nnl.rocks.projects.spkro.pets

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class GetPetUseCaseImpl(
    private val repository: PetEntityRepository
) : GetPetUseCase {

    @Transactional(readOnly = true)
    override fun invoke(id: UUID): PetEntity {
        return repository.getOne(id)
    }
}
