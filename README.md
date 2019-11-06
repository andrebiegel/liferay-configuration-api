# Configuration API in Liferay DXP
This repository explores the functionality liferay dxp provides with the new configuration api. It builds upon the osgi configuration admin. Furthermore it allows scoping of configuration and the integration within the system settings ui with configuration categories.


TESTED UPON DXP 7.2 SP1

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
The plugins adds the following capability in the manifest fiel of your bundle.

```
liferay.resource.bundle;bundle.symbolic.name="de.abiegel.configuration.osgi.example";resource.bundle.base.name="content.Language"
```

## Configuration Categories
Categories itself are created by an osgi service of the interface *com.liferay.configuration.admin.category.ConfigurationCategory* (see [1]).
The interface is included in the following dependency.

```
<dependency>
  <groupId>com.liferay</groupId>
  <artifactId>com.liferay.configuration.admin.api</artifactId>
  <version>1.0.0</version>
  <scope>provided</scope>
</dependency>
```

Every liferay configuration category is defined within the *com.liferay.configuration.admin.web* bundle. But any category language property is going to be provided by the resource-bundle the module defines by itself !! The resource bundle *Language* carries the category and section label. 


A configuration category can have a custom icon. Available Icons are provided by Clay UI (see [2])

The following existing ones, can also be used:

* content
* platform
* security
* other
* social
* commerce

(extracted from https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-web/src/main/resources/content/Language.properties)


the language keys for categories and sections must follow a specific format. Prefix each section language key with category-section. and each category language key with category. For example:
*category-section.content-and-data=Content* and Data *category.dynamic-data-mapping=Dynamic Data Mapping*  (https://portal.liferay.dev/docs/7-2/frameworks/-/knowledge_base/f/categorizing-the-configuration)

## Configuration Scopes

The following scopes are available.

* System (default)
* company
* Group aka Site 
* Portlet Instance

It is important to enable metatypes in your bnd file. Otherwise bnd won´t recognize the bnd annotations used in liferay. So if you are missing the config, the first place to check, is the *OSGI-INF/metadata* directory in the jar file.

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
## Dynamic Configuraltion Select Lists

The ConfigurationFieldOptionsProvider allows you to populate select lists with configuration options defined by your custom logic.


The following property in an configuration interface in combination with the imoplementation in tne company sammple will end up in the following ui 


![Dynamic Select List](liferay-scoped-company/images/dynamic.PNG "Dynamic Select List")

```java
@AD(deflt = "enabled-with-warning", name = "foo-default-name-entry-list",description = "foo-default-name-entry-list-desc", optionLabels = { "enabled", "enabled-with-warning",
			"disabled" }, optionValues = { "enabled", "enabled-with-warning", "disabled" }, required = false)
	String entryList();
```

```java
@Component(property = { "configuration.field.name=entryList",
        "configuration.pid=de.abiegel.configuration.osgi.company.CompanyConfiguredComponentConfig"
         }, service = ConfigurationFieldOptionsProvider.class)
public class MyConfigurationFieldOptionsProvider implements ConfigurationFieldOptionsProvider {

    @Override
    public List<Option> getOptions() {
    }
}
```

(https://portal.liferay.dev/docs/7-2/frameworks/-/knowledge_base/f/dynamically-populating-select-list-fields-in-the-configuration-ui)
## Known Issues

* so far: category sections are correctly displayed with DXP 7.1 Fixpack 10  
* DXP 7.1 FP 10: exporting configurations: when exporting configurations, liferay is providing the mediatype as *XML* and not as *config*. ..the old way was in xml
* since DXP 7.2 exporting Configurations is only possible with system settings, but these will get loaded as config files, every piece in instance setting does not have this functionality
* DXP 7.2 The custom category just displays one element .. to see others deactivate the other  bundles!
+ dynamic lists wont run in dxp 7.2 ga 1, the samples run in sp 1

## Open Topics
*  the portlet example contains a ConfigurationPidMapping Implementation. it is unclear what it acually does .. it has been adapted from the liferay blogs portlet (https://community.liferay.com/de/forums/-/message_boards/message/113426189?_com_liferay_message_boards_web_portlet_MBPortlet_showBreadcrumb=false) by experimenting .. the class is responsible for connecting the osgi config instance the ui in the portlet scope sampe otherwhise default values will not be visible 
* the section categories labels dont not have to be provided by a module override.. but actually the config-admin-web portlet displays them, so i think the way liferay suggests is defining such a override https://community.liferay.com/de/forums/-/message_boards/message/113234099?_com_liferay_message_boards_web_portlet_MBPortlet_showBreadcrumb=false


## Sources

* https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration
* https://clayui.com/docs/components/icons.html

[1]: https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-1/categorizing-the-configuration  "Creating Configuration Categories"

[2]: https://clayui.com/docs/components/icons.html  "Clay UI Icons"

[4]: https://github.com/liferay/liferay-portal/blob/master/modules/apps/configuration-admin/configuration-admin-api/src/main/java/com/liferay/configuration/admin/category/ConfigurationCategory.java  "ConfigurationCategory"





