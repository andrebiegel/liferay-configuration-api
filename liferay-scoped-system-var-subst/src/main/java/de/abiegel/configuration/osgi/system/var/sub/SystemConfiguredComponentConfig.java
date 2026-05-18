package de.abiegel.configuration.osgi.system.var.sub;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.system.constants.ConfigurationKeys;


@ExtendedObjectClassDefinition(scope = Scope.SYSTEM, category = "my-foo-system-var")
@OCD( id = ConfigurationKeys.CONFIGURATION_NAME, localization = "content/Language", name = "foo-system-default-name", description= "foo-system-default-name-desc")
public interface SystemConfiguredComponentConfig {

	@AD(required = false, name = "foo-system-default-name-entry", deflt = "os Name", description= "foo-system-default-name-entry-desc")
	String systemProp();
	
	@AD(required = false, name = "foo-system-default-liferay-env-entry", deflt = "ENV VAR", description= "foo-system-default-liferay-env-name-entry-desc")
	String defaultLiferayEnvProp();
	
	@AD(required = false, name = "foo-system-default-env-entry", deflt = "ENV VAR", description= "foo-system-default-env-name-entry-desc")
	String defaultEnvProp();
	
}
