package nnl.rocks.projects.spkro.veterinarians

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import nnl.rocks.projects.spkro.core.PageInfo
import java.util.UUID

@ApiModel(description = "Page of veterinarian specialties")
class SpecialtiesVM(

    @ApiModelProperty("Pageable info", required = true)
    val pageInfo: PageInfo,

    @ApiModelProperty("Content", required = true)
    val elements: List<SpecialtyVM>
)

@ApiModel(description = "Veterinarian specialty")
class SpecialtyVM(

    @ApiModelProperty("Id", required = true)
    val id: UUID,

    @ApiModelProperty("Name", required = true)
    val name: String
)

@ApiModel(description = "Page of veterinarians")
class VeterinariansVM(

    @ApiModelProperty("Pageable info", required = true)
    val pageInfo: PageInfo,

    @ApiModelProperty("Content", required = true)
    val elements: List<VeterinarianVM>
)

@ApiModel(description = "Veterinarian")
class VeterinarianVM(

    @ApiModelProperty("Id", required = true)
    val id: UUID,

    @ApiModelProperty("Name", required = true)
    val name: String
)

fun SpecialtyEntity.toSpecialtyVM(): SpecialtyVM = SpecialtyVM(id = id, name = name)

fun VeterinarianEntity.toVeterinarianVM(): VeterinarianVM = VeterinarianVM(id = id, name = name)
