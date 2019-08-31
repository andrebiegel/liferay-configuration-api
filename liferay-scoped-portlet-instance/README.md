# Portlet Instance Scoped Configurations
Since DXP 7.2: 
Use PortletDisplay. This is the recommended approach for configurations at the PORTLET_INSTANCE scope, but only works at that scope.
the ConfigurationProviderUtil will not work here (in 7.2)

"https://portal.liferay.dev/docs/7-2/frameworks/-/knowledge_base/f/reading-scoped-configuration-values"


The Config can be viewes in System and Instance settings
## System Settings - Views
![Configuration Category of Fooable](images/system-settings.PNG "Configuration Category of Fooable")

![Group Scoped Example](images/fooableThings.PNG "Portlet-Instance Scoped Example")
## Portlet - Views

![View](images/view-view.PNG "View")
![Configuration](images/configuration-view.PNG "Configuration")

## Configuration View

![Configuration](images/configuration-view.png "Configuration")
