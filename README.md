#  FASOJUG Adopts JSR 367
This repository contains the file of regular sessions for adopting the  JCP  specification  [JSR 367](https://jcp.org/en/jsr/detail?id=367)
## Configure your development environment

After cloning the repository, install the json-ri in local repository with this command:  
```mvn install:install-file -Dfile=javax.json.bind-api.jar -DgroupId=org.eclipse.persistence -DartifactId=jsonb-ri -Dversion=1.0-SNAPSHOT -Dpackaging=jar ```
  
    
    Modify  your pom.xml to have the tags in bold
    
    ```
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>
    
    <dependencies>       
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency> 
        <!-- JSONB dependencies -->        
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>jsonb-ri</artifactId>
            <version>1.0</version>
        </dependency>       
    </dependencies>
```
