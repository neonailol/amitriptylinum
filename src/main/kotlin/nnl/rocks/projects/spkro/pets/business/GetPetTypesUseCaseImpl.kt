package nnl.rocks.projects.spkro.pets

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetPetTypesUseCaseImpl(
    private val petTypeEntityRepository: PetTypeEntityRepository
) : GetPetTypesUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<PetTypeEntity> {
        return petTypeEntityRepository.findAll(
            nameContains(query),
            pageable
        )
    }
}
