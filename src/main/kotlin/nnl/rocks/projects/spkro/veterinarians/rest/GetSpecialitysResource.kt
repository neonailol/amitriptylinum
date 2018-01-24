package nnl.rocks.projects.spkro.veterinarians

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import nnl.rocks.projects.spkro.core.ApiTags
import nnl.rocks.projects.spkro.core.toPageInfo
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = [ApiTags.PUBLIC, ApiTags.VETERINARIANS])
class GetSpecialtiesResource(
    private val getSpecialties: GetSpecialtiesUseCase
) {

    @GetMapping("/api/v1/veterinarians/specialties")
    @ApiOperation("Get list of available veterinarian specialties")
    @PreAuthorize("permitAll()")
    operator fun invoke(

        @ApiParam("query string for filtering")
        @RequestParam(required = false)
        query: String?,

        @ApiParam("pageable params, default is first 50 entries")
        @PageableDefault(size = 50)
        pageable: Pageable
    ): SpecialtiesVM {
        return getSpecialties(query, pageable)
            .map { it.toSpecialtyVM() }
            .let { SpecialtiesVM(it.toPageInfo(), it.content) }
    }
}

