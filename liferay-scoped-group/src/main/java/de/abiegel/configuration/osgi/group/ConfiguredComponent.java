package de.abiegel.configuration.osgi.group;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author usiabiegel
 */
@Component(configurationPid = {
		"de.abiegel.configuration.osgi.group.GroupConfiguredComponentConfig" }, immediate = true, service = Fooable.class)
public class ConfiguredComponent implements Fooable {

	private static final Log logger = LogFactoryUtil.getLog(ConfiguredComponent.class);

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private CompanyLocalService companyLocalService;

	private GroupConfiguredComponentConfig configuration;

	@Activate
	@Modified
	protected void readConfig() {
		long groupId = 0;
		try {
			Company company = companyLocalService.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			this.configuration = configurationProvider.getGroupConfiguration(GroupConfiguredComponentConfig.class,
					company.getGroup().getGroupId());
		} catch ( PortalException e) {
			logger.fatal("Cannot Acces config", e);
		}
	}


	@Override
	public void foo(){
		logger.fatal("evil things can be done with " + configuration.defaultName());
	}

}