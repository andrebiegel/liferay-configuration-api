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
Categories itself are created by an osgi service of the class com.liferay.configuration.admin.category.ConfigurationCategory (see [1]).
The Class is included in the following dependency.

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

## Configurations Scopes

The following scopes are available.

* System (default)
* company
* Group  aka Site 
* Portlet Instance

## Sources

[1]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration  "Creating Configuration Categories"

[2]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/overriding-a-modules-language-keys  "OVERRIDING A MODULE’S LANGUAGE KEYS"

[3]: https://clayui.com/docs/components/icons.html  "Clay UI Icons"



