package com.acttopia.main.global.configs

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {

    @Bean
    fun openApi(
        @Value("\${springdoc.swagger-ui.version}")
        version: String
    ): OpenAPI {
        val info = Info()
            .version(version)
            .description("act topia 백엔드 api 명세서")
            .contact(
                Contact()
                    .email("alex108902@naver.com")
                    .name("강모민")
            )

        val auth = SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .`in`(SecurityScheme.In.HEADER)
            .name("X-Auth-Token")

        val securityRequirement = SecurityRequirement()
        securityRequirement.addList("JWT")

        return OpenAPI()
            .components(Components().addSecuritySchemes("JWT", auth))
            .addSecurityItem(securityRequirement)
            .info(info)
    }
}