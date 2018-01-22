package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import nnl.rocks.projects.spkro.core.entityCreated
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.PETS])
class CreatePetResource(
    private val createPet: CreatePetUseCase
) {

    @PostMapping("/api/v1/pets")
    @ApiOperation("Create new pet")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @RequestBody
        @Validated
        command: CreatePetCommand
    ): ResponseEntity<Unit> {
        return entityCreated(createPet(command))
    }
}

