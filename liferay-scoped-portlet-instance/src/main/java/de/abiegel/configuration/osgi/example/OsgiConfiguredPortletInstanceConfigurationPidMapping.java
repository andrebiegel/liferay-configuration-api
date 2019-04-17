package de.abiegel.configuration.osgi.example;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

@Component
public class OsgiConfiguredPortletInstanceConfigurationPidMapping implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return ConfiguredComponentConfig.class;
	}

	@Override
	public String getConfigurationPid() {
		return "de_abiegel_configuration_osgi_example_OsgiConfiguredPortlet";
	}

}
