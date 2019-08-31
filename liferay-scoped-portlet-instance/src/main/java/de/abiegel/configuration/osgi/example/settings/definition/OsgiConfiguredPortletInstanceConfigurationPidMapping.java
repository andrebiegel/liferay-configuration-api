package de.abiegel.configuration.osgi.example.settings.definition;

import org.osgi.service.component.annotations.Component;

import de.abiegel.configuration.osgi.example.ConfiguredComponentConfig;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

/**
 * 
 * connects the osgi configuration with the instance the internal instance in the setup ui provides , without that the default value is not going to be displayed
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
