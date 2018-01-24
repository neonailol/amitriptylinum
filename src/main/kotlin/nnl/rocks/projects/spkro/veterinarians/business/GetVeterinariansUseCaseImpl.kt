package nnl.rocks.projects.spkro.veterinarians

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetVeterinariansUseCaseImpl(
    private val VeterinarianEntityRepository: VeterinarianEntityRepository
) : GetVeterinariansUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<VeterinarianEntity> {
        return VeterinarianEntityRepository.findAll(
            veterinarianNameContains(query),
            pageable
        )
    }
}
