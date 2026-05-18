# Configuration Form Renderer

When you create a configuration interface, a configuration UI is automatically generated. But in some cases you want customize the look and feel of the UI. For example, you want to modify the UI to match the design aesthetics of your company. Here’s how to do it with a ConfigurationFormRenderer implementation
. If you want to execute a Action you have to use an Configuration ScreenContributor. 

As it can be seen .. liferay generate also the default UI in LIferay DXP.
HINT If you are trying to circumvent that by setting generateUI .. Is will completely hide the configuration category (but the category section is there)

```java
@ExtendedObjectClassDefinition(
    //generateUI = false,
    category = "vocabulary-configuration",
    scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
```

![Configuration Category](images/category.PNG "Configuration Category")

![Configuration Layout](images/config.PNG "Configuration Layout")

## Sources

* https://help.liferay.com/hc/en-us/articles/360028726212-Customizing-the-Configuration-User-Interface
* https://help.liferay.com/hc/en-us/articles/360029045771-Configuration-Form-Renderer


