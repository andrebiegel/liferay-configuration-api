<%@ include file="/osgiconfiguredportlet/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />


<liferay-frontend:edit-form action="<%=configurationActionURL%>"
	method="post" name="fm">

	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="redirect" type="hidden"
		value="<%=configurationRenderURL%>" />

	<liferay-frontend:edit-form-body>
		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset collapsible="<%=false%>"
				label="general-settings">
				<aui:input name="preferences--foo-default-name-entry--" type="text"
					value="<%=configuration.defaultName()%>" />

			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>
		<liferay-frontend:edit-form-footer>
			<aui:button type="submit" />

			<aui:button type="cancel" />
		</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>