package de.abiegel.configuration.osgi.example;

import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.OCD;


@ExtendedObjectClassDefinition(scope = Scope.GROUP, category = "collaboration")
@OCD( id = "de.abiegel.configuration.osgi.example.ConfiguredComponentConfig", localization = "content/Language", name = "foo-default-name")
@ObjectClassDefinition(name = "foo-default-name")
public @interface ConfiguredComponentConfig {

	@AD(required = false, name = "foo-default-name-entry", deflt = "FOO")
	String defaultName() default "Foo";
}
