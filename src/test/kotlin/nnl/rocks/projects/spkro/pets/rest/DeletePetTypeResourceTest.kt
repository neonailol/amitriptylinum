package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.UUID

class DeletePetTypeResourceTest : ApplicationTest() {
    @Test
    fun testDeletePetTypeSuccess() {
        val petTypeId = UUID.randomUUID()
        val petTypeName = "testGetPetTypeSuccess"

        petTypeEntityRepository.save(PetTypeEntity(petTypeId, petTypeName))

        mockMvc.perform(
            petsApi.deletePetType(petTypeId)
        ).andExpect(
            status().isNoContent
        )
    }
}
