package de.abiegel.configuration.osgi.group;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;


@ExtendedObjectClassDefinition(scope = Scope.GROUP, category = "my-foo")
@OCD( id = "de.abiegel.configuration.osgi.group.GroupConfiguredComponentConfig", localization = "content/Language", name = "foo-default-name", description= "foo-default-name-desc")
public @interface GroupConfiguredComponentConfig {

	@AD(required = false, name = "foo-default-name-entry", deflt = "FOO", description= "foo-default-name-entry-desc")
	String defaultName() default "Foo";
}
