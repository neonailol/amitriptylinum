package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.andExpect
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.UUID

class GetPetTypeResourceTest : ApplicationTest() {

    @Test
    fun testGetPetTypeSuccess() {
        val petTypeId = UUID.randomUUID()
        val petTypeName = "testGetPetTypeSuccess"

        petTypeEntityRepository.save(PetTypeEntity(petTypeId, petTypeName))

        mockMvc.perform(
            petsApi.getPetType(petTypeId)
        ).andExpect(
            status().isOk,
            content().contentType("application/json;charset=UTF-8"),
            jsonPath("$.id").value(petTypeId.toString()),
            jsonPath("$.name").value(petTypeName)
        )
    }
}
