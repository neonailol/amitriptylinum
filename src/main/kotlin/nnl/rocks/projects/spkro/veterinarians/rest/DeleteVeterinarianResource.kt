package nnl.rocks.projects.spkro.veterinarians

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.VETERINARIANS])
class DeleteVeterinarianResource(
    private val deleteVeterinarian: DeleteVeterinarianUseCase
) {

    @DeleteMapping("/api/v1/veterinarians/{id}")
    @ApiOperation("Get concrete veterinarian")
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ) {
        return deleteVeterinarian(id)
    }
}

