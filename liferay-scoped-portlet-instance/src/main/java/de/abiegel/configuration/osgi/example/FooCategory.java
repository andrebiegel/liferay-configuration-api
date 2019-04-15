package de.abiegel.configuration.osgi.example;

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

}
