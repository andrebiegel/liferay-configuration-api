package de.abiegel.configuration.osgi.company;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.company.constants.ConfigurationKeys;

@ExtendedObjectClassDefinition(scope = Scope.COMPANY, category = "my-foo-company")
@OCD(id = ConfigurationKeys.CONFIGURATION_NAME, localization = "content/Language", name = "foo-company-default-name", description = "foo-company-default-name-desc")
public interface CompanyConfiguredComponentConfig {

	@AD(required = false, name = "foo-company-default-name-entry", deflt = "FOO", description = "foo-company-default-name-entry-desc")
	String defaultName();

	@AD( name = "foo-company-default-name-entry-list",description = "foo-company-default-name-entry-list-desc",  required = false)
	String entryList();
}
