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

```
liferay.resource.bundle;bundle.symbolic.name="de.abiegel.configuration.osgi.example";resource.bundle.base.name="content.Language"
```

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

Every liferay configuration category is defined within the *com.liferay.configuration.admin.web* bundle. But any category language property is going to be provided by the resource-bundle the module defines by itself !! The resource bundle Language carries the category and section label. 

A configuration category can have a custom icon. Available Icons are provided by Clay UI (see [2])

The following existing can also be used:

* content
* platform
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

It is important to enable metatypes in your bnd file. Otherwise bnd won´t recognize the bnd annotations used in liferay. So if you are missing the config the first place to check is the OSGI-INF/metadata directory in the jar file.

```
-metatype: *
```

```Xml
<?xml version='1.0' encoding='UTF-8'?>
<metatype:MetaData xmlns:metatype="http://www.osgi.org/xmlns/metatype/v1.1.0" localization="content/Language">
  <OCD name="foo-default-name" id="de.abiegel.configuration.osgi.example.ConfiguredComponentConfig" description="foo-default-name-desc">
    <AD name="foo-default-name-entry" id="defaultName" cardinality="0" required="false" default="FOO" type="String" description="foo-default-name-entry-desc"/>
  </OCD>
  <Designate pid="de.abiegel.configuration.osgi.example.ConfiguredComponentConfig">
    <Object ocdref="de.abiegel.configuration.osgi.example.ConfiguredComponentConfig"/>
  </Designate>
</metatype:MetaData>
```

## Known Issues

* soa far: category sections are correctly displayed with DXP 7.1 Fixpack 10  
* Exporting configurations: when exportings configurations , liferay is providing the mediatype as XML and not as config. ..the old way was in xml

## Open Topics
*  the portlet example contains a ConfigurationPidMapping Implementation. it is unclear what it acually does .. it has been adapted from the liferay blogs portlet (https://community.liferay.com/de/forums/-/message_boards/message/113426189?_com_liferay_message_boards_web_portlet_MBPortlet_showBreadcrumb=false)


## Sources

* https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration
* https://clayui.com/docs/components/icons.html

[1]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration  "Creating Configuration Categories"

[2]: https://clayui.com/docs/components/icons.html  "Clay UI Icons"

[4]: https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-api/src/main/java/com/liferay/configuration/admin/category/ConfigurationCategory.java  "ConfigurationCategory"





