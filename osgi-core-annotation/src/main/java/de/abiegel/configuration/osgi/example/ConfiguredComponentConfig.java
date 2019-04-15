package de.abiegel.configuration.osgi.example;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "foo-default-name", description = "Example Configuration Description" , localization="content.Language")
public @interface ConfiguredComponentConfig {

	@AttributeDefinition(name = "foo-default-name-entry", required = true, type = AttributeType.STRING, description = "The default Name.")
	String defaultName() default "Foo";
}
