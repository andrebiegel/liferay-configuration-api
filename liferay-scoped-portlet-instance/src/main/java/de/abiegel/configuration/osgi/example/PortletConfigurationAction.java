package de.abiegel.configuration.osgi.example;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;
import jakarta.portlet.PortletConfig;
import jakarta.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(
		configurationPid = "de.abiegel.configuration.osgi.example.ConfiguredComponentConfig",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		immediate = true,
		property = {
				"jakarta.portlet.name=de_abiegel_configuration_osgi_example_OsgiConfiguredPortlet" },
		service = ConfigurationAction.class)
public class PortletConfigurationAction extends DefaultConfigurationAction {
	
	private static final Log logger = LogFactoryUtil.getLog(PortletConfigurationAction.class);
	
	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
			throws Exception {
		
		setPreference(
				actionRequest, "defaultName",
				ParamUtil.getString(actionRequest, "preferences--defaultName--"));
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
}
