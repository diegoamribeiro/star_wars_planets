package com.diegoribeiro.star_wars.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun planetsApi(): Docket {
        return  Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.diegoribeiro.star_wars"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())
    }

    private fun metaData(): ApiInfo{
        return ApiInfoBuilder()
            .title("API dos planetas de Star Wars")
            .description("API que possui todos os métodos da aplicação")
            .version("1.0.0")
            .build()
    }

}