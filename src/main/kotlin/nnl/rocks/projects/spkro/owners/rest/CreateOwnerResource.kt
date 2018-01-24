package nnl.rocks.projects.spkro.owners

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
@Api(tags = [ApiTags.PUBLIC, ApiTags.OWNERS])
class CreateOwnerResource(
    private val createOwner: CreateOwnerUseCase
) {

    @PostMapping("/api/v1/owners")
    @ApiOperation("Create new owner")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @RequestBody
        @Validated
        command: CreateOwnerCommand
    ): ResponseEntity<Unit> {
        return entityCreated(createOwner(command))
    }
}

