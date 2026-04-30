Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/apache/felix/org.apache.felix.webconsole/4.3.16/org.apache.felix.webconsole-4.3.16-all.jar" -OutFile "./deploy/org.apache.felix.webconsole-4.3.16-all.jar" `
&& mvn clean package `
&& Get-ChildItem -Recurse -Filter *.jar -Include */target/* | Move-Item -Destination ./deploy/ `
&& docker-compose up -d
