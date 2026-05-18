package de.abiegel.configuration.osgi.example;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.example.constants.ConfigurationKeys;

@ExtendedObjectClassDefinition(scope = Scope.PORTLET_INSTANCE, category = "my-foo-portlet")
@OCD(
		id = ConfigurationKeys.CONFIGURATION_NAME,
		localization = "content/Language",
		name = "foo-portlet-default-name",
		description = "foo-portlet-default-name-desc")
public @interface ConfiguredComponentConfig {
	
	@AD(
			required = false,
			name = "foo-portlet-default-name-entry",
			deflt = "FOO",
			description = "foo-portlet-default-name-entry-desc")
	String defaultName() default "Foo";
}
