package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.PETS])
class DeletePetTypeResource(
    private val deletePetType: DeletePetTypeUseCase
) {

    @DeleteMapping("/api/v1/pets/types/{id}")
    @ApiOperation("Get concrete pet type")
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    operator fun invoke(

        @ApiParam("Identifier")
        @PathVariable(required = true)
        id: UUID
    ) {
        return deletePetType(id)
    }
}

