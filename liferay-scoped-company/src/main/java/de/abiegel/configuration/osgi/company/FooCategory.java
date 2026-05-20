package de.abiegel.configuration.osgi.company;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component
public class FooCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "my-foo-company";
	}

	@Override
	public String getCategorySection() {
		return "my-foo-title";
	}

	/**
	 * choose one of
	 * @see https://www.clayui.com/docs/components/icon
	 */
	@Override
	public String getCategoryIcon() {

		return "third-party";
	}
}
