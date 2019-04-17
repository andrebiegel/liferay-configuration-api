package de.abiegel.configuration.osgi.example;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.BaseJSPSettingsConfigurationAction;
import com.liferay.portal.kernel.portlet.ConfigurationAction;

@Component(
	    configurationPid = "com.liferay.docs.exampleconfig.configuration.ExampleConfiguration",
	    immediate = true,
	    property = {
	        "javax.portlet.name=de_abiegel_configuration_osgi_example_OsgiConfiguredPortlet"
	    },
	    service = ConfigurationAction.class
	)
public class PortletConfigurationAction extends BaseJSPSettingsConfigurationAction  {

	 private static final Log logger = LogFactoryUtil.getLog(PortletConfigurationAction.class);

	 @Override
		public String getJspPath(HttpServletRequest httpServletRequest) {
			return "/osgiconfiguredportlet/configuration.jsp";
		}

		@Override
		@Reference(
			target = "(osgi.web.symbolicname=de.abiegel.configuration.osgi.example)", unbind = "-"
		)
		public void setServletContext(ServletContext servletContext) {
			super.setServletContext(servletContext);
	}
}
