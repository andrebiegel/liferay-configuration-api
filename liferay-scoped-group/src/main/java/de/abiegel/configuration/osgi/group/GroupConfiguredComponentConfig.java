package de.abiegel.configuration.osgi.group;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.group.constants.ConfigurationKeys;

@ExtendedObjectClassDefinition(scope = Scope.GROUP, category = "my-foo-group")
@OCD( id = ConfigurationKeys.CONFIGURATION_NAME, localization = "content/Language", name = "foo-group-default-name", description= "foo-group-default-name-desc")
public @interface GroupConfiguredComponentConfig {

	@AD(required = false, name = "foo-group-default-name-entry", deflt = "FOO", description= "foo-group-default-name-entry-desc")
	String defaultName() default "Foo";
}
