package de.abiegel.configuration.osgi.group;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component
public class FooCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {

		return "my-foo-group";
	}

	@Override
	public String getCategorySection() {
		return "my-foo-group-title";
	}

	/**
	 * choose one of
	 * @see https://clayui.com/docs/components/icons.html
	 */
	@Override
	public String getCategoryIcon() {

		return "third-party";
	}
//FIXME: please
	/**
	 * What is that for ??
	 */
	@Override
	public String getBundleSymbolicName() {
		return "de.abiegel.configuration.osgi.group";
	}

	
}
