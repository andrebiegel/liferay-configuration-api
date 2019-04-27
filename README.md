# Configuration API in Liferay DXP
This repository explores the functionality liferay dxp provides with the new configuration api. It builds upon the osgi configuration admin. Furthermore it allows scoping of configuration and the integration within the system settings ui with configuration categories.

In this repository are five examples located:
* [Pure OSGI Example](/osgi-core-annotation/README.md)
* [System scoped configuration with osgi service](/liferay-scoped-system/README.md)
* [Company scoped configuration with osgi service](/liferay-scoped-company/README.md)
* [Group scoped configuration with osgi service](/liferay-scoped-group/README.md)
* [Portlet instance scoped configuration with a Liferay MVC Portlet in combination with a Configuration JSP action ](/liferay-scoped-portlet-instance/README.md)
Each Examples follows the same principles and just shows an valid variant (eg. in scope).

## Localization 
To localize the  Configuration itself, the following BND-file entry has to be existent, in addtion to a resource-bundle located in src/main/resources

```
-plugin.bundle: com.liferay.ant.bnd.resource.bundle.ResourceBundleLoaderAnalyzerPlugin
```
The plugins adds a capability in the manifest.

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

Every liferay configuration category is defined within the *com.liferay.configuration.admin.web* bundle. Therefore any category language property has to be provided by a module language property override(see [2]). While playing with the notation, i found out , that the resource bundles can be splitted. In all scoped examples the resource-bundle Language.properties contains properties for the configuration interface. The resource bundle CategoryLanguage carries the category  and section label. 

```
Provide-Capability:\
liferay.resource.bundle;resource.bundle.aggregate:String="(bundle.symbolic.name=de.abiegel.configuration.osgi.example),(bundle.symbolic.name=com.liferay.configuration.admin.web)";bundle.symbolic.name=com.liferay.configuration.admin.web;resource.bundle.base.name="content.CategoryLanguage";service.ranking:Long="2";\
```

A configuration category can have a custom icon. Available Icons are provided by Clay UI (see [3])

Because of the known issue regarding the section label, it is recommened to use the existing sections so far. The following can be used:

* content
* plattform
* security
* other
* social
* commerce

(extracted from https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-web/src/main/resources/content/Language.properties)


## Configuration Scopes

The following scopes are available.

* System (default)
* company
* Group aka Site 
* Portlet Instance

It is important to enable metatypes in your bnd file. Otherwise bnd won´t recognize the bnd annotations used in liferay.
```
-metatype: *
```
## Known Issues

* Language Property Issue: with the the group-scoped example the category section labels fails, but the category labels is resolved. When deploying the company scoped version even the category label fails. When exluding the the configuration category and deploying it separately, it is like the group scoped example .. Strange Things  , the topic is  also in the forums https://community.liferay.com/de/forums/-/message_boards/message/113234099
* Exporting configurations: when exportings configurations , liferay is providing the mediatype as XML and not as config. ..the old way was in xml
* the confog category Label is not displayed in every variant: The tests have been done with sp 9.. so far the workaroung is to deploy the category separately .. 

## Open Topics
*  the portlet example contains a ConfigurationPidMapping Implementation. it is unclear what it acually does .. it has been adapted from the liferay blogs portlet (https://community.liferay.com/de/forums/-/message_boards/message/113426189?_com_liferay_message_boards_web_portlet_MBPortlet_showBreadcrumb=false)

[1]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration  "Creating Configuration Categories"

[2]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/overriding-a-modules-language-keys  "OVERRIDING A MODULE’S LANGUAGE KEYS"

[3]: https://clayui.com/docs/components/icons.html  "Clay UI Icons"

[4]: https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-api/src/main/java/com/liferay/configuration/admin/category/ConfigurationCategory.java  "ConfigurationCategory"





