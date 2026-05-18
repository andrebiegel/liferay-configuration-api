/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.abiegel.configuration.osgi.example;

import java.io.IOException;
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import jakarta.portlet.Portlet;
import jakarta.portlet.PortletException;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		configurationPid = {
				"de.abiegel.configuration.osgi.example.ConfiguredComponentConfig" },
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.instanceable=true",
				"jakarta.portlet.version=4.0",
				"jakarta.portlet.name=de_abiegel_configuration_osgi_example_OsgiConfiguredPortlet",
				"jakarta.portlet.display-name=Portlet Configuration Example",
				"jakarta.portlet.init-param.template-path=/osgiconfiguredportlet/",
				"jakarta.portlet.supports.mime-type=text/html",
				"jakarta.portlet.resource-bundle=content.Language",
				"jakarta.portlet.security-role-ref=power-user,user",
				"jakarta.portlet.init-param.config-template=/osgiconfiguredportlet/configuration.jsp",
				"jakarta.portlet.init-param.view-template=/osgiconfiguredportlet/view.jsp"
		},
		service = Portlet.class
)
public class OsgiConfiguredPortlet extends MVCPortlet {
	
	private static final Log logger = LogFactoryUtil.getLog(OsgiConfiguredPortlet.class);
	
	private volatile ConfiguredComponentConfig configuration;
	
	@Reference
	private ConfigurationProvider configurationProvider;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		configuration = getConfiguredComponentConfig(renderRequest);
		
		renderRequest.setAttribute(
				ConfiguredComponentConfig.class.getName(), configuration);
		super.doView(renderRequest, renderResponse);
	}
	
	private ConfiguredComponentConfig
	getConfiguredComponentConfig(RenderRequest renderRequest)
			throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		try {
			return configurationProvider.getPortletInstanceConfiguration(
					ConfiguredComponentConfig.class, themeDisplay);
		}
		catch (ConfigurationException configurationException) {
			throw new PortletException(configurationException);
		}
	}
}
