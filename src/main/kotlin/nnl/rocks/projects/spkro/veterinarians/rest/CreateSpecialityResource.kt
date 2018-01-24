package nnl.rocks.projects.spkro.veterinarians

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
@Api(tags = [ApiTags.PUBLIC, ApiTags.VETERINARIANS])
class CreateSpecialtyResource(
    private val createSpecialty: CreateSpecialtyUseCase
) {

    @PostMapping("/api/v1/veterinarians/specialties")
    @ApiOperation("Create new veterinarian specialty")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @RequestBody
        @Validated
        command: CreateSpecialtyCommand
    ): ResponseEntity<Unit> {
        return entityCreated(createSpecialty(command))
    }
}

