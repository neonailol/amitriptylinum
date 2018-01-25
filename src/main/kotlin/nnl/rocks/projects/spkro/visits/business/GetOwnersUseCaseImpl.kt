package nnl.rocks.projects.spkro.visits

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetVisitsUseCaseImpl(
    private val VisitEntityRepository: VisitEntityRepository
) : GetVisitsUseCase {

    @Transactional(readOnly = true)
    override fun invoke(
        query: String?,
        pageable: Pageable
    ): Page<VisitEntity> {
        return VisitEntityRepository.findAll(
            pageable
        )
    }
}
