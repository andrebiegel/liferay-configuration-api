package de.abiegel.configuration.osgi.system;

import com.liferay.configuration.admin.category.ConfigurationCategory;

//@Component
public class FooCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "my-foo-system";
	}

	@Override
	public String getCategorySection() {
		return "my-foo-system-title";
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
