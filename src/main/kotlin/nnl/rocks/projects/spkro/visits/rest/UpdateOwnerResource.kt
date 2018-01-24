package nnl.rocks.projects.spkro.visits

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.VISITS])
class UpdateVisitResource(
    private val updateVisit: UpdateVisitUseCase
) {

    @PutMapping("/api/v1/visits/{id}")
    @PreAuthorize("permitAll()")
    @ApiOperation("Update visit info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    operator fun invoke(

        @PathVariable
        id: UUID,

        @RequestBody
        @Validated
        command: UpdateVisitCommand
    ) {
        updateVisit(id, command)
    }
}
