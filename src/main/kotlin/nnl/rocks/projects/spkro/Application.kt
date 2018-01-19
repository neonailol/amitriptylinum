package nnl.rocks.projects.spkro

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableWebMvc
@EnableWebSecurity(debug = true)
@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories
@EnableTransactionManagement
@EnableSwagger2
class Application

@Configuration
class SecurityConf : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/**")
            .permitAll()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
