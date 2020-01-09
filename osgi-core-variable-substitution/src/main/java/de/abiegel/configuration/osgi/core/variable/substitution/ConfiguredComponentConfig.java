package de.abiegel.configuration.osgi.core.variable.substitution;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "foo-default-name", description = "foo-default-name-desc" , localization="content/Language")
public @interface ConfiguredComponentConfig {

	@AttributeDefinition(name = "foo-default-env-entry", required = true, type = AttributeType.STRING, description = "foo-default-name-entry-desc")
	String defaultEnvVar() default "Foo";

	
	@AttributeDefinition(name = "foo-default-system-entry", required = true, type = AttributeType.STRING, description = "foo-default-name-entry-desc" )
	String defaultSystemPropVar() default "Foo";

}
