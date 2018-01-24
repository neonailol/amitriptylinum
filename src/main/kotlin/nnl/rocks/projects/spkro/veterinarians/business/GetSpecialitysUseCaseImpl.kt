package nnl.rocks.projects.spkro.veterinarians

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetSpecialtiesUseCaseImpl(
    private val veterinarianTypeEntityRepository: SpecialtyEntityRepository
) : GetSpecialtiesUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<SpecialtyEntity> {
        return veterinarianTypeEntityRepository.findAll(
            nameContains(query),
            pageable
        )
    }
}
