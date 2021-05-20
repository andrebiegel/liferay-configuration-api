package de.abiegel.configuration.osgi.liferay.ddm.form;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;

@DDMForm
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.SINGLE_PAGE_MODE,
	value = {
		@DDMFormLayoutPage(
			{
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"textArrayValues", "date",
								"select"
							}
						)
					}
				),
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 6, value = "numeric"
						),
						@DDMFormLayoutColumn(size = 6, value = "checkbox")
					}
				)
			}
		)
	}
)
public interface MyFooConfigurationForm {

	@DDMFormField(
		label = "%label-key-for-field-1",
		tip = "%description-key-for-field-1",
		properties = {

			"placeholder=%enter-a-value",
			"tooltip=%some-tooltip-text"
		}
	)
	public String[] textArrayValues();

	@DDMFormField(
		label = "%date",
		tip = "%date-description",
		type = "date")
	public String date();

	@DDMFormField(
		label = "%select",
		optionLabels = {"%foo", "%bar"},
		optionValues = {"foo", "bar"},
		type = "select")
	public String select();

	@DDMFormField(
		label = "%numeric",
		properties = {
			"placeholder=%milliseconds",
			"tooltip=%enter-an-integer-between-1000-and-30000"
		},
		validationErrorMessage = "%please-enter-an-integer-between-1000-and-30000-milliseconds",
		validationExpression = "(numeric >= 1000) && (numeric <= 30000)",
		type = "numeric")
	public String numeric();

	@DDMFormField(
		label = "%checkbox",
		properties = "showAsSwitcher=true")
	public boolean checkbox();

}
