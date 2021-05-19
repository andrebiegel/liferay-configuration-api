package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import aQute.bnd.annotation.metatype.Meta;

import static de.abiegel.configuration.osgi.liferay.configuration.form.renderer.constants.VocabularyConfigurationKeys.CONFIGURATION_NAME;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
    generateUI = false,
    category = "vocabulary-configuration",
    scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(id = CONFIGURATION_NAME,
    localization = "content/Language",
    name = "vocabulary-configuration")
public interface VocabularyConfiguration {

    @Meta.AD(
        deflt = "-1",
        name = "vocabulary",
        required = false,
        description = "Vocabulary selection"
    )
    long vocabulary();
}
