package de.abiegel.configuration.category.foo;

import org.osgi.service.component.annotations.Component;

import com.liferay.configuration.admin.category.ConfigurationCategory;

@Component
public class FooCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "my-foo";
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
