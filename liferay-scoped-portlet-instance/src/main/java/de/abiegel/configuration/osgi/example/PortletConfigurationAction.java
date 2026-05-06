package de.abiegel.configuration.osgi.example;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

@Component(configurationPid = "de.abiegel.configuration.osgi.example.ConfiguredComponentConfig", configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = {
		"jakarta.portlet.name=de_abiegel_configuration_osgi_example_OsgiConfiguredPortlet" }, service = ConfigurationAction.class)
public class PortletConfigurationAction extends DefaultConfigurationAction {

	private static final Log logger = LogFactoryUtil.getLog(PortletConfigurationAction.class);

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/osgiconfiguredportlet/configuration.jsp";
	}

	@Override
	@Reference(target = "(osgi.web.symbolicname=de.abiegel.configuration.osgi.portlet.instance)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}
}
