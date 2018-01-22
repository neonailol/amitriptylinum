package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.PETS])
class GetPetTypeResource(
    private val getPetType: GetPetTypeUseCase
) {

    @GetMapping("/api/v1/pets/types/{id}")
    @ApiOperation("Get concrete pet type")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ): PetTypeVM {
        return getPetType(id).toPetTypeVM()
    }
}

