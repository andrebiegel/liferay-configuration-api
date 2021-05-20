package de.abiegel.configuration.osgi.liferay.ddm.form;

import com.liferay.configuration.admin.definition.ConfigurationDDMFormDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "configurationPid=de.abiegel.configuration.osgi.liferay.ddm.form.CompanyConfiguredComponentConfig",
	service = ConfigurationDDMFormDeclaration.class
)
public class FooConfigurationDDMFormDeclaration
	implements ConfigurationDDMFormDeclaration {

	@Override
	public Class<?> getDDMFormClass() {
		return MyFooConfigurationForm.class;
	}

}
