#  FASOJUG Adopts JSR 367
This repository contains the file of regular sessions for adopting the  JCP  specification  [JSR 367](https://jcp.org/en/jsr/detail?id=367)
## Configure your development environment

After cloning the repository, install the json-ri in local repository with this command:  
```mvn install:install-file -Dfile=javax.json.bind-api.jar -DgroupId=org.eclipse.persistence -DartifactId=jsonb-ri -Dversion=1.0-SNAPSHOT -Dpackaging=jar ```
  
Open the project JSONBTestSpec ( it is a maven Java web application built with NetBeans). Some tests have been integrated but you are free to test any other part of the specification.
