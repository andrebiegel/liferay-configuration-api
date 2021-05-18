package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class VocabularyConfigurationCategory implements ConfigurationCategory {

    private static final String CATEGORY_ICON = "cog";
    private static final String CATEGORY_KEY = "vocabulary-configuration";
    private static final String CATEGORY_SECTION = "vocabulary-configuration";

    /**
     * Gets a string with the name of the icon used in the instance setting's main panel
     *
     * @return a string representing the name of the icon
     */
    @Override
    public String getCategoryIcon() {
        return CATEGORY_ICON;
    }

    /**
     * Gets a string with the key of the category used in the instance setting's main panel
     *
     * @return a string representing the key of the category
     */
    @Override
    public String getCategoryKey() {
        return CATEGORY_KEY;
    }

    /**
     * Gets a string with the name of the section used instance setting's main panel
     *
     * @return a string representing the name of the category section
     */
    @Override
    public String getCategorySection() {
        return CATEGORY_SECTION;
    }
}
