package de.abiegel.configuration.osgi.liferay.ddm.form;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

/**
 * 
 * @author abiegel
 * @see https://dev.liferay.com/de/develop/tutorials/-/knowledge_base/7-1/scoping-configurations
 */
@Component
public class ConfiguredComponentConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return CompanyConfiguredComponentConfig.class;
	}

}
