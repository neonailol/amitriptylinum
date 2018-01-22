package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.andExpect
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class GetPetTypesResourceTest : ApplicationTest() {

    @Test
    fun testGetPetTypesSuccess() {
        mockMvc.perform(
            petsApi.getPetTypes()
        ).andExpect(
            status().isOk,
            content().contentType("application/json;charset=UTF-8"),
            jsonPath("$.pageInfo.elementsCount").value(3)
        )
    }
}
