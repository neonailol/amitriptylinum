package nnl.rocks.projects.spkro.veterinarians

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface VeterinarianEntityRepository : JpaRepository<VeterinarianEntity, UUID>, JpaSpecificationExecutor<VeterinarianEntity>

@Repository
interface SpecialtyEntityRepository : JpaRepository<SpecialtyEntity, UUID>, JpaSpecificationExecutor<SpecialtyEntity>
