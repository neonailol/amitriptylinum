package nnl.rocks.projects.spkro.veterinarians

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.VETERINARIANS])
class GetVeterinarianResource(
    private val getVeterinarian: GetVeterinarianUseCase
) {

    @GetMapping("/api/v1/veterinarians/{id}")
    @ApiOperation("Get concrete veterinarian")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ): VeterinarianVM {
        return getVeterinarian(id).toVeterinarianVM()
    }
}

