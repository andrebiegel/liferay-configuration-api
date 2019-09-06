package de.abiegel.configuration.osgi.company;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author usiabiegel
 */
@Component(configurationPid = {
		"de.abiegel.configuration.osgi.company.CompanyConfiguredComponentConfig" }, configurationPolicy = ConfigurationPolicy.OPTIONAL, property = {
				"osgi.command.scope=foo", "osgi.command.function=foo" }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private CompanyLocalService companyLocalService;

	private CompanyConfiguredComponentConfig configuration;

	@Activate
	@Modified
	protected void readConfig() {

		try {
			Company company = companyLocalService.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			this.configuration = configurationProvider.getCompanyConfiguration(CompanyConfiguredComponentConfig.class,
					company.getCompanyId());
		} catch (PortalException e) {
			logger.fatal("Cannot Acces config", e);
		}
	}

	@Override
	public void foo() {
		logger.fatal("evil things can be done with " + configuration.defaultName());
	}

}