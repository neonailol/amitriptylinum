package nnl.rocks.projects.spkro.visits

import nnl.rocks.projects.spkro.owners.OwnerEntity
import nnl.rocks.projects.spkro.pets.PetEntity
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
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
        date = LocalDateTime.now(),
        description = "",
        pet = PetEntity(
            id = UUID.randomUUID(),
            name = "",
            birthday = LocalDateTime.now(),
            type = PetTypeEntity(
                id = UUID.randomUUID(),
                name = ""
            ),
            owner = OwnerEntity(
                id = UUID.randomUUID(),
                name = "",
                address = "",
                phone = ""
            )
        )
    )
}
