package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.Api
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
@Api(tags = [ApiTags.PUBLIC, ApiTags.PETS])
class UpdatePetTypeResource(
    private val updatePetType: UpdatePetTypeUseCase
) {

    @PutMapping("/api/v1/pets/types/{id}")
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    operator fun invoke(

        @PathVariable
        id: UUID,

        @RequestBody
        @Validated
        command: UpdatePetTypeCommand
    ) {
        updatePetType(id, command)
    }
}
