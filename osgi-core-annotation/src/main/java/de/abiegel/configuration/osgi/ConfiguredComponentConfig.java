package de.abiegel.configuration.osgi;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "foo-default-name", description = "foo-default-name-desc" , localization="content/Language")
public @interface ConfiguredComponentConfig {

	@AttributeDefinition(name = "foo-default-name-entry", required = true, type = AttributeType.STRING, description = "foo-default-name-entry-desc")
	String defaultName() default "Foo";
}
