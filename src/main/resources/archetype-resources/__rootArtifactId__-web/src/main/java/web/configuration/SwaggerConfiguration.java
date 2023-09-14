package ${groupId}.web.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.Parameter;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
    public OpenAPI api(@Value("${sicatel.version}") String appVersion) {
		
		return new OpenAPI()
				.components(
					new Components()
					.addParameters("x-region", 
							new Parameter()
							.in("header")
							.schema(new StringSchema())
							.name("x-region"))
					.addParameters("Authorization", 
							new Parameter()
							.in("header")
							.schema(new StringSchema())
							.name("Authorization").description("Bearer Token")))
				.info(new Info()
					.title("${rootArtifactId}-api")
					.version(appVersion)
					.description("${rootArtifactId}-api")
					.description("You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).")
					.termsOfService("http://swagger.io/terms/")
			.license(new License().name("Apache 2.0").url("http://springdoc.org")));	
    }
	
	@Bean
	public GroupedOpenApi publicGroup() {
	    return GroupedOpenApi.builder()
	        .packagesToScan("${groupId}.web.resources")
	        .pathsToMatch("/**")
	        .group("public")
	        .addOpenApiCustomiser(globalHeaderCustomizer())
	        .build();
	}
	
	OpenApiCustomiser globalHeaderCustomizer() {
	    return openApi -> openApi.getPaths().values().stream().flatMap(pathItem -> pathItem.readOperations().stream())
	        .forEach(operation -> operation.addParametersItem(
	            new HeaderParameter().$ref("#/components/parameters/x-region"))
				.addParametersItem(new HeaderParameter().$ref("#/components/parameters/Authorization")));
	}
}
