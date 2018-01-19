package nnl.rocks.projects.spkro.pets

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PetEntityRepository : JpaRepository<PetEntity, UUID>, JpaSpecificationExecutor<PetEntity>
