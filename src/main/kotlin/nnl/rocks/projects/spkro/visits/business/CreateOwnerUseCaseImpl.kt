package nnl.rocks.projects.spkro.visits

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
class CreateVisitUseCaseImpl(
    private val repository: VisitEntityRepository
) : CreateVisitUseCase {

    @Transactional
    override fun invoke(command: CreateVisitCommand): UUID {
        return repository.save(command.toEntity()).id
    }
}

fun CreateVisitCommand.toEntity(): VisitEntity {
    return VisitEntity(
        id = UUID.randomUUID(),
        name = name,
        address = "",
        phone = ""
    )
}
