package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import nnl.rocks.projects.spkro.core.ApiTags
import nnl.rocks.projects.spkro.core.responseEntityCreated
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.PETS])
class CreatePetTypeResource(
    private val createPetType: CreatePetTypeUseCase
) {

    @PostMapping("/api/v1/pets/types")
    @ApiOperation("Create new pet type")
    @PreAuthorize("permitAll()")
    operator fun invoke(

        @ApiParam("Body")
        @RequestBody
        @Validated
        command: CreatePetTypeCommand
    ): ResponseEntity<Unit> {
        return responseEntityCreated(createPetType(command))
    }
}

