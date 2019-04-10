package de.abiegel.configuration.osgi.example;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "Example Configuration", description = "Example Configuration Description")
public @interface ConfiguredComponentConfig {

	@AttributeDefinition(name = "Default Name", required = true, type = AttributeType.STRING, description = "The default Name.")
	String defaultName() default "Foo";
}
