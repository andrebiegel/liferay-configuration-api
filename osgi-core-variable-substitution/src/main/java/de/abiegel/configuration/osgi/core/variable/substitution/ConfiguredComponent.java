package de.abiegel.configuration.osgi.core.variable.substitution;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

/**
 * @author usiabiegel
 */
@Designate(ocd = ConfiguredComponentConfigVarSubstitution.class)
@Component(configurationPid = {
		"de.abiegel.configuration.osgi.core.variable.substitution.ConfiguredComponentConfigVarSubstitution" }, immediate = true, service = Fooable.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	private ConfiguredComponentConfigVarSubstitution configuration;

	@Activate
	@Modified
	protected void readConfig(final ConfiguredComponentConfigVarSubstitution config) {
		this.configuration = config;
	}

	@Override
	public void foo() {
		logger.fatal("Env var Property entry" + configuration.defaultEnvVar());
		logger.fatal("System Property  entry" + configuration.defaultSystemPropVar());
	}

}
