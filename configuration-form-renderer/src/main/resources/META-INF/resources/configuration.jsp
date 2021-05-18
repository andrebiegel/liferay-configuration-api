<%@ include file="init.jsp" %>

<aui:select label="${countryConfigurationDisplayContext.fieldLabel}"
            name="vocabulary"
            value="${countryConfigurationDisplayContext.currentVocabularyId}">

    <c:forEach items="${countryConfigurationDisplayContext.vocabularies}"
               var="currentVocabulary">
        <aui:option label="${currentVocabulary[1]}"
                    selected="${countryConfigurationDisplayContext.currentVocabularyId eq currentVocabulary[0]}"
                    value="${currentVocabulary[0]}" />
    </c:forEach>

</aui:select>
<div id="putzmeister-warning"><liferay-ui:message key="country-vocabulary-warning" /></div>

