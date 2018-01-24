package nnl.rocks.projects.spkro.veterinarians

data class CreateSpecialtyCommand(
    val name: String
)

data class UpdateSpecialtyCommand(
    val name: String
)

data class CreateVeterinarianCommand(
    val name: String
)

data class UpdateVeterinarianCommand(
    val name: String
)
