package nnl.rocks.projects.spkro.visits

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface VisitEntityRepository : JpaRepository<VisitEntity, UUID>, JpaSpecificationExecutor<VisitEntity>
