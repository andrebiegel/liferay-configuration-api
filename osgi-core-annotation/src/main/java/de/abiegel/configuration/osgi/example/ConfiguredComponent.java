package de.abiegel.configuration.osgi.example;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author usiabiegel
 */
@Designate(ocd = ConfiguredComponentConfig.class)

@Component(configurationPid = {
		"de.abiegel.configuration.osgi.example.ConfiguredComponentConfig" }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	private ConfiguredComponentConfig configuration;

	@Activate
	@Modified
	protected void readConfig(ConfiguredComponentConfig config) {
		this.configuration = config;
	}

	@Override
	public void foo(){
		logger.fatal("evil things can be done with " + configuration.defaultName());
	}

}