package de.abiegel.configuration.osgi.liferay.ddm.form;

import com.liferay.configuration.admin.definition.ConfigurationDDMFormDeclaration;
import de.abiegel.configuration.osgi.liferay.ddm.form.constants.ConfigurationKeys;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "configurationPid=" + ConfigurationKeys.CONFIGURATION_NAME,
	service = ConfigurationDDMFormDeclaration.class
)
public class FooConfigurationDDMFormDeclaration
	implements ConfigurationDDMFormDeclaration {

	@Override
	public Class<?> getDDMFormClass() {
		return MyFooConfigurationForm.class;
	}

}
