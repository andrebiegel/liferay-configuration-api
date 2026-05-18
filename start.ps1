Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/apache/felix/org.apache.felix.webconsole/5.0.18/org.apache.felix.webconsole-5.0.18.jar" -OutFile "./deploy/org.apache.felix.webconsole-4.3.16-all.jar" `
&& mvn clean package `
&& docker-compose up -d
