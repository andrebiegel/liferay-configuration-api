# Configuration API in Liferay DXP
This repository explores the functionality liferay dxp provides with the new configuration api. It builds upon the osgi configuration admin. furthermore it allows a configuration scoping and the integration within the system settings ui with configuration categories.

In this repository are four examples located:
* [Pure OSGI Example](/osgi-core-annotation/README.md)
* [System scoped configuration with osgi service](/liferay-scoped-system/README.md)
* [Company scoped configuration with osgi service](/liferay-scoped-company/README.md)
* [Group scoped configuration with osgi service](/liferay-scoped-group/README.md)
* [Portlet instance scoped configuration with a Liferay MVC Portlet in combination with a Configuration JSP action ](/liferay-scoped-portlet-instance/README.md)

## Important Notes 

## Configuration Categories
Categories itself are created by an osgi service of the interface com.liferay.configuration.admin.category.ConfigurationCategory (see [1]).
The interface is included in the following dependency.

```
<dependency>
  <groupId>com.liferay</groupId>
  <artifactId>com.liferay.configuration.admin.api</artifactId>
  <version>1.0.0</version>
  <scope>provided</scope>
</dependency>
```

Every liferay configuration category is defined within the *com.liferay.configuration.admin.web* bundle. Therefore any category language property has to be provided by a module language property override(see [2]).

A configuration category can have a custom icon. Available Icons are provided by Clay UI (see [3])

Because of the known issue regarding. the section label it is recommened to use the existing sections so far. The following can be used:

* content
* plattform
* security
* other
* social
* commerce

(extracted from https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-web/src/main/resources/content/Language.properties)


## Configurations Scopes

The following scopes are available.

* System (default)
* company
* Group aka Site 
* Portlet Instance

It is important to enable metatypes in your bnd file. Otherwise bnd won´t recognize the bnd annotations used in liferay.

## Known Issues

* Language Property Issue: with the the group-scoped example the category section labels fails, but the category labels is resolved. When deploying the company scoped version even the category label fails. When exluding the the configuration category and deploying it separately, it is like the group scoped example .. Strange Things  , the topic is  also in the forums https://community.liferay.com/de/forums/-/message_boards/message/113234099
* Exporting configurations: when exportings configurations , liferay is providing the mediatype as XML and not as config. ..the old way was in xml

## Open Topics
*  the portlet example contains a ConfigurationPidMapping Implementation. it is unclear what it acually does .. it has been adapted from the liferay blogs portlet

[1]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration  "Creating Configuration Categories"

[2]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/overriding-a-modules-language-keys  "OVERRIDING A MODULE’S LANGUAGE KEYS"

[3]: https://clayui.com/docs/components/icons.html  "Clay UI Icons"

[4]: https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-api/src/main/java/com/liferay/configuration/admin/category/ConfigurationCategory.java  "ConfigurationCategory"





