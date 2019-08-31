package de.abiegel.configuration.osgi.company;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;


@ExtendedObjectClassDefinition(scope = Scope.COMPANY, category = "my-foo")
@OCD( id = "de.abiegel.configuration.osgi.company.CompanyConfiguredComponentConfig", localization = "content/Language", name = "foo-default-name", description= "foo-default-name-desc")
public @interface CompanyConfiguredComponentConfig {

	@AD(required = false, name = "foo-default-name-entry", deflt = "FOO", description= "foo-default-name-entry-desc")
	String defaultName() default "Foo";
}