package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import de.abiegel.configuration.osgi.liferay.configuration.form.renderer.constants.VocabularyConfigurationKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author usiabiegel
 */

@Component( configurationPid = {
		VocabularyConfigurationKeys.CONFIGURATION_NAME }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable{

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	private VocabularyConfiguration configuration;
	@Activate
	@Modified
	protected void readConfig() {
		try {
			this.configuration = configurationProvider.getSystemConfiguration(VocabularyConfiguration.class);
		} catch (ConfigurationException e) {
			logger.fatal("Cannot Acces config", e);
		}
	}

	
	public void foo(){
		logger.fatal("evil things can be done with " + configuration);
	}

}
