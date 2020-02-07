package com.galvanize.gmdbmovies.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}


//    OTHER CONFIG
//    @Bean
//    public Docket eDesignApi(SwaggerConfigProperties swaggerConfigProperties) {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo(swaggerConfigProperties)).enable(Boolean.valueOf(swaggerConfigProperties.getEnabled())).select().apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()).build().pathMapping("/").directModelSubstitute(LocalDate.class, String.class)
//                .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(Boolean.valueOf(swaggerConfigProperties.getUseDefaultResponseMessages()))
//                .enableUrlTemplating(Boolean.valueOf(swaggerConfigProperties.getEnableUrlTemplating()));
//    }
//    @Bean
//    UiConfiguration uiConfig(SwaggerConfigProperties swaggerConfigProperties) {
//        return UiConfigurationBuilder.builder().deepLinking(Boolean.valueOf(swaggerConfigProperties.getDeepLinking())).displayOperationId(Boolean.valueOf(swaggerConfigProperties.getDisplayOperationId()))
//                .defaultModelsExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelsExpandDepth())).defaultModelExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelExpandDepth()))
//                .defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(Boolean.valueOf(swaggerConfigProperties.getDisplayRequestDuration())).docExpansion(DocExpansion.NONE)
//                .filter(Boolean.valueOf(swaggerConfigProperties.getFilter())).maxDisplayedTags(Integer.valueOf(swaggerConfigProperties.getMaxDisplayedTags())).operationsSorter(OperationsSorter.ALPHA)
//                .showExtensions(Boolean.valueOf(swaggerConfigProperties.getShowExtensions())).tagsSorter(TagsSorter.ALPHA)
//                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null).build();
//    }
//    private ApiInfo apiInfo(SwaggerConfigProperties swaggerConfigProperties) {
//        return new ApiInfoBuilder().title(swaggerConfigProperties.getTitle()).description(swaggerConfigProperties.getDescription())
//                .version(swaggerConfigProperties.getApiVersion()).build();
//    }