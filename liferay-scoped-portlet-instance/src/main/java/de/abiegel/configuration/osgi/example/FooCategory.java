package de.abiegel.configuration.osgi.example;

import com.liferay.configuration.admin.category.ConfigurationCategory;

//@Component
public class FooCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "my-foo-portlet";
	}

	@Override
	public String getCategorySection() {
		return "my-foo-portlet-title";
	}
	/**
	 * choose one of
	 * @see https://clayui.com/docs/components/icons.html
	 */
	@Override
	public String getCategoryIcon() {

		return "third-party";
	}

	/**
	 * What is that for ??
	 */
	@Override
	public String getBundleSymbolicName() {
		return "de.abiegel.configuration.osgi.example";
	}

}
