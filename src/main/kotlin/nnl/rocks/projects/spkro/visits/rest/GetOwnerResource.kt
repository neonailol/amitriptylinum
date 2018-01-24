package nnl.rocks.projects.spkro.visits

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import nnl.rocks.projects.spkro.core.ApiTags
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.VISITS])
class GetVisitResource(
    private val getVisit: GetVisitUseCase
) {

    @GetMapping("/api/v1/visits/{id}")
    @ApiOperation("Get concrete visit")
    @PreAuthorize("permitAll()")
    operator fun invoke(
        @PathVariable(required = true)
        id: UUID
    ): VisitVM {
        return getVisit(id).toVisitVM()
    }
}

