package de.abiegel.configuration.osgi.system;

import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import de.abiegel.configuration.osgi.system.constants.ConfigurationKeys;
import de.abiegel.configuration.osgi.system.var.sub.SystemConfiguredComponentConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author usiabiegel
 */

@Component(configurationPid = {
		ConfigurationKeys.CONFIGURATION_NAME }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	private SystemConfiguredComponentConfig configuration;
	@Activate
	@Modified
	protected void readConfig() {
		try {
			this.configuration = configurationProvider.getSystemConfiguration(SystemConfiguredComponentConfig.class);
		} catch (ConfigurationException e) {
			logger.fatal("Cannot Acces config", e);
		}
	}

	@Override
	public void foo(){
		logger.fatal("evil things can be done with " + configuration.systemProp());
	}

}
