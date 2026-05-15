package de.abiegel.configuration.osgi.liferay.ddm.form;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;
import de.abiegel.configuration.osgi.liferay.ddm.form.constants.ConfigurationKeys;

@ExtendedObjectClassDefinition(scope = Scope.COMPANY, category = "ddm-form-sample")
@OCD(id = ConfigurationKeys.CONFIGURATION_NAME, localization = "content/Language", name = "foo-ddm-form-default-name", description = "foo-ddm-form-default-name-desc")
public @interface CompanyConfiguredComponentConfig {

	@AD(required = false, name = "foo-ddm-form-default-name-entry", deflt = "FOO", description = "foo-ddm-form-default-name-entry-desc")
	public String[] textArrayValues();

	@AD(required = false, name = "foo-ddm-form-default-name-entry", deflt = "", description = "foo-ddm-form-default-name-entry-desc")
	public String date();

	@AD(required = false, name = "foo-ddm-form-default-name-entry", deflt = "", description = "foo-ddm-form-default-name-entry-desc")
	public String select();
	@AD(required = false, name = "foo-ddm-form-default-name-entry", deflt = "", description = "foo-ddm-form-default-name-entry-desc")
	public String numeric();
	@AD(required = false, name = "foo-ddm-form-default-name-entry", deflt = "", description = "foo-ddm-form-default-name-entry-desc")
	public boolean checkbox();

}
