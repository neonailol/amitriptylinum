package nnl.rocks.projects.spkro

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.web.config.SpringDataWebConfiguration
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement
class Application

@Configuration
class DataWebConfiguration : SpringDataWebConfiguration()

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
