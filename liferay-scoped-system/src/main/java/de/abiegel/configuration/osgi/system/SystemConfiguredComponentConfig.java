package de.abiegel.configuration.osgi.system;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.system.constants.ConfigurationKeys;

@ExtendedObjectClassDefinition(scope = Scope.SYSTEM, category = "my-foo-system")
@OCD( id = ConfigurationKeys.CONFIGURATION_NAME, localization = "content/Language", name = "foo-system-default-name", description= "foo-system-default-name-desc")
public interface SystemConfiguredComponentConfig {

	@AD(required = false, name = "foo-system-default-name-entry", deflt = "FOO", description= "foo-system-default-name-entry-desc")
	String defaultName();
}
