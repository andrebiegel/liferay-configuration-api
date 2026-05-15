<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.acme.u2g5.web.internal.configuration.U2G5WebConfiguration" %>

<h4>U2G5 Custom Configuration</h4>

<%
U2G5WebConfiguration u2g5WebConfiguration = (U2G5WebConfiguration)request.getAttribute(U2G5WebConfiguration.class.getName());
%>

<p
	style="color: <%= u2g5WebConfiguration.fontColor() %>; font-family: <%= u2g5WebConfiguration.fontFamily() %>; font-size: <%= u2g5WebConfiguration.fontSize() %>pt;"
>
	<liferay-ui:message key="u2g5-configuration" /><br />
	color: <%= u2g5WebConfiguration.fontColor() %><br />
	font-family: <%= u2g5WebConfiguration.fontFamily() %><br />
	font-size: <%= u2g5WebConfiguration.fontSize() %>
</p>