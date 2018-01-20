package nnl.rocks.projects.spkro.pets

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import nnl.rocks.projects.spkro.core.PageInfo
import java.util.UUID

@ApiModel(description = "Page of pet types")
class PetTypesVM(

    @ApiModelProperty("Pageable info", required = true)
    val pageInfo: PageInfo,

    @ApiModelProperty("Content", required = true)
    val elements: List<PetTypeVM>
)

@ApiModel(description = "Pet type")
class PetTypeVM(

    @ApiModelProperty("Id", required = true)
    val id: UUID,

    @ApiModelProperty("Name", required = true)
    val name: String
)

fun PetTypeEntity.toPetTypeVM(): PetTypeVM = PetTypeVM(
    id = id,
    name = name
)
