package de.abiegel.configuration.osgi;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "foo-default-core-name", description = "foo-default-core-name-desc" , localization="content/Language")
public @interface ConfiguredComponentConfigCoreOsgi {

	@AttributeDefinition(name = "foo-default-core-name-entry", required = true, type = AttributeType.STRING, description = "foo-default-core-name-entry-desc")
	String defaultName() default "Foo";
}
