package nnl.rocks.projects.spkro.pets

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetPetsUseCaseImpl(
    private val PetEntityRepository: PetEntityRepository
) : GetPetsUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<PetEntity> {
        return PetEntityRepository.findAll(
            petNameContains(query),
            pageable
        )
    }
}
