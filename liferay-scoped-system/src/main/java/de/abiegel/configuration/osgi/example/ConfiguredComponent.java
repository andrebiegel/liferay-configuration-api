package de.abiegel.configuration.osgi.example;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;

/**
 * @author usiabiegel
 */

@Component(configurationPid = {
		"de.abiegel.configuration.osgi.example.ConfiguredComponentConfig" }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	private ConfiguredComponentConfig configuration;
	@Activate
	@Modified
	protected void readConfig() {
		try {
			this.configuration = configurationProvider.getSystemConfiguration(ConfiguredComponentConfig.class);
		} catch (ConfigurationException e) {
			logger.fatal("Cannot Acces config", e);
		}
	}

	@Override
	public void foo(){
		logger.fatal("evil things can be done with " + configuration.defaultName());
	}

}