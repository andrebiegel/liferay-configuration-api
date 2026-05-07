package de.abiegel.configuration.osgi.core.variable.substitution;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "foo-default-name-var-sub", description = "foo-default-name-var-sub-desc" , localization="content/Language")
public @interface ConfiguredComponentConfigVarSubstitution {

	@AttributeDefinition(name = "foo-default-var-sub-env-entry", required = true, type = AttributeType.STRING, description = "foo-default-var-sub-name-entry-desc")
	String defaultEnvVar() default "$[env:PATH]";

	
	@AttributeDefinition(name = "foo-default-var-sub-system-entry", required = true, type = AttributeType.STRING, description = "foo-default-var-sub-name-entry-desc" )
	String defaultSystemPropVar() default "$[os.name]";

}
