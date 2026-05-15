package de.abiegel.configuration.osgi.liferay.ddm.form;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component
public class DDMFormCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "ddm-form-sample";
	}

	@Override
	public String getCategorySection() {
		return "my-foo-title";
	}

	/**
	 * choose one of
	 * @see https://clayui.com/docs/components/icons.html
	 */
	@Override
	public String getCategoryIcon() {

		return "third-party";
	}
}
