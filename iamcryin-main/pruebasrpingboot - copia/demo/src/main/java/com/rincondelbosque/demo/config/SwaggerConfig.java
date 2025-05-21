package com.rincondelbosque.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomizer;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/**")
				.addOpenApiCustomizer(openApiCustomizer())
				.build();
	}
	
	private OpenApiCustomizer openApiCustomizer() {
		return openApi -> openApi.info(new Info()
				.title("Test swagger")
				.version("1.0.0")
				.description("Api test para java"));
	}
	
}