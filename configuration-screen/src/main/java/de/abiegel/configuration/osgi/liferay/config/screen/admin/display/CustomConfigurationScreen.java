package de.abiegel.configuration.osgi.liferay.config.screen.admin.display;

import de.abiegel.configuration.osgi.liferay.config.screen.ConfigScreenWebConfiguration;

import com.liferay.configuration.admin.display.ConfigurationScreen;
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.io.IOException;

import java.util.Locale;
import de.abiegel.configuration.osgi.liferay.config.screen.ConfigScreenWebConfiguration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ConfigurationScreen.class)
public class CustomConfigurationScreen implements ConfigurationScreen {

	@Override
	public String getCategoryKey() {
		return "third-party";
	}

	@Override
	public String getKey() {
		return "config-screen-configuration-name";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(locale, CustomConfigurationScreen.class),
			"config-screen-configuration-name");
	}

	@Override
	public String getScope() {
		return "system";
	}

	@Override
	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		try {
			RequestDispatcher requestDispatcher =
				_servletContext.getRequestDispatcher("/view.jsp");

			httpServletRequest.setAttribute(
					ConfigScreenWebConfiguration.class.getName(),
				_configurationProvider.getSystemConfiguration(
						ConfigScreenWebConfiguration.class));

			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (Exception exception) {
			throw new IOException("Unable to render /view.jsp", exception);
		}
	}

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference(
		target = "(osgi.web.symbolicname=de.abiegel.configuration.screen.sample)", unbind = "-"
	)
	private ServletContext _servletContext;

}
