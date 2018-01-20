package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class GetPetTypesResourceTest : ApplicationTest() {

    @Test
    fun testGetPetTypesSuccess() {
        mockMvc.perform(
            get("/api/v1/pets/types").accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(
            status().isOk
        ).andExpect(
            content().contentType("application/json;charset=UTF-8")
        ).andExpect(
            jsonPath("$.pageInfo.elementsCount").value(3)
        )
    }
}
