package de.abiegel.configuration.osgi.liferay.config.screen;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * generateUI = false has to be set so that liferay will not generate a default ui for that configuration
 */
@ExtendedObjectClassDefinition(
	category = "config-screen", generateUI = false,
	scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
	id = "de.abiegel.configuration.osgi.liferay.config.screen.ConfigScreenWebConfiguration",
	localization = "content/Language", name = "config-screen-configuration-name"
)
public interface ConfigScreenWebConfiguration {

	@Meta.AD(deflt = "blue", required = false)
	public String fontColor();

	@Meta.AD(deflt = "serif", required = false)
	public String fontFamily();

	@Meta.AD(deflt = "16", required = false)
	public int fontSize();

}
