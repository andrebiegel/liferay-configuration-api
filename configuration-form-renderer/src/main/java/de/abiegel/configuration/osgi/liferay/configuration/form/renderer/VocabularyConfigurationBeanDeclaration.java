package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import org.osgi.service.component.annotations.Component;

/**
 * This class is needed by OSGi to obtain the proper ConfigurationFormRenderer
 */
@Component
public class VocabularyConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return VocabularyConfiguration.class;
    }
}
