<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="de.abiegel.configuration.osgi.liferay.config.screen.ConfigScreenWebConfiguration" %>

<h4>Custom Configuration Screen Configuration</h4>

<%
    ConfigScreenWebConfiguration webConfiguration = (ConfigScreenWebConfiguration)request.getAttribute(ConfigScreenWebConfiguration.class.getName());
%>

<p
	style="color: <%= webConfiguration.fontColor() %>; font-family: <%= webConfiguration.fontFamily() %>; font-size: <%= webConfiguration.fontSize() %>pt;"
>
	<liferay-ui:message key="config.screen-configuration" /><br />
	color: <%= webConfiguration.fontColor() %><br />
	font-family: <%= webConfiguration.fontFamily() %><br />
	font-size: <%= webConfiguration.fontSize() %>
</p>
