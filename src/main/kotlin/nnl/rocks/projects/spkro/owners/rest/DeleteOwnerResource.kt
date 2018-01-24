package nnl.rocks.projects.spkro.owners

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
@Api(tags = [ApiTags.PUBLIC, ApiTags.OWNERS])
class DeleteOwnerResource(
    private val deleteOwner: DeleteOwnerUseCase
) {

    @DeleteMapping("/api/v1/owners/{id}")
    @ApiOperation("Get concrete owner")
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ) {
        return deleteOwner(id)
    }
}

