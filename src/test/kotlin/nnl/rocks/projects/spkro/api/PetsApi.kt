package nnl.rocks.projects.spkro.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.util.UUID

@Component
class PetsApi {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    fun getPetTypes(): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .get("/api/v1/pets/types")
            .accept(MediaType.APPLICATION_JSON_VALUE)
    }

    fun getPetType(id: Any): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .get("/api/v1/pets/types/$id")
            .accept(MediaType.APPLICATION_JSON_VALUE)
    }

    fun deletePetType(id: Any): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .delete("/api/v1/pets/types/$id")
            .accept(MediaType.APPLICATION_JSON_VALUE)
    }

    fun createPetType(content: CreatePetTypeRB): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .post("/api/v1/pets/types")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsBytes(content))
    }

    fun updatePetType(
        id: UUID,
        content: UpdatePetTypeRB
    ): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .put("/api/v1/pets/types/${id}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsBytes(content))
    }
}

data class CreatePetTypeRB(
    val name: String
)

data class UpdatePetTypeRB(
    val name: String
)
