package nnl.rocks.projects.spkro.owners

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.OWNERS])
class GetOwnerResource(
    private val getOwner: GetOwnerUseCase
) {

    @GetMapping("/api/v1/owners/{id}")
    @ApiOperation("Get concrete owner")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ): OwnerVM {
        return getOwner(id).toOwnerVM()
    }
}

