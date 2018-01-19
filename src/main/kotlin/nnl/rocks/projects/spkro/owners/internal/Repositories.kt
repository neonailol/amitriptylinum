package nnl.rocks.projects.spkro.owners

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OwnerEntityRepository : JpaRepository<OwnerEntity, UUID>, JpaSpecificationExecutor<OwnerEntity>
