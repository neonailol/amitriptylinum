package nnl.rocks.projects.spkro.owners

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetOwnersUseCaseImpl(
    private val OwnerEntityRepository: OwnerEntityRepository
) : GetOwnersUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<OwnerEntity> {
        return OwnerEntityRepository.findAll(
            nameContains(query),
            pageable
        )
    }
}
