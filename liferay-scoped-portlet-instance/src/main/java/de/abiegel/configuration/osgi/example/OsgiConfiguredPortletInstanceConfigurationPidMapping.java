package de.abiegel.configuration.osgi.example;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

/**
 * 
 * Seems to connect the osgi configuration with the instance the ConfigurationProviderUtil provides , without that the default value is not going to be displayed
 *
 */
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
