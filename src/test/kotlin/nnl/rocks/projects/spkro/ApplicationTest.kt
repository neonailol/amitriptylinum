package nnl.rocks.projects.spkro

import nnl.rocks.projects.spkro.pets.PetTypeEntity
import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import java.util.UUID

@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = [Application::class], webEnvironment = RANDOM_PORT)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class ApplicationTest {

    @Autowired
    internal lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var petTypeEntityRepository: PetTypeEntityRepository

    @Test
    fun contextLoads() {
    }

    @Before
    fun init() {
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type1"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type2"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type3"))
    }
}
