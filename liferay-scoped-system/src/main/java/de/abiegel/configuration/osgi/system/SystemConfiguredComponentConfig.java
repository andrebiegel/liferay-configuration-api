package de.abiegel.configuration.osgi.system;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;


@ExtendedObjectClassDefinition(scope = Scope.SYSTEM, category = "my-foo-system")
@OCD( id = "de.abiegel.configuration.osgi.system.SystemConfiguredComponentConfig", localization = "content/Language", name = "foo-default-name", description= "foo-default-name-desc")
public @interface SystemConfiguredComponentConfig {

	@AD(required = false, name = "foo-default-name-entry", deflt = "FOO", description= "foo-default-name-entry-desc")
	String defaultName() default "Foo";
}
