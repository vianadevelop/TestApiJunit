# automated-api-testing
Este repositorio tiene como objetivo la automatización de pruebas a API utilizando Rest Assured, Cucumber, SerenityBDD, Java, Maven e IntelliJ

* Para ejecutar el proyecto usar: 
```` mvn clean verify serenity:aggregate ````
* Para ejecutar usando perfiles usar el parámetro -P{env}

    ```` mvn clean verify serenity:aggregate -Pdev````

    ```` mvn clean verify serenity:aggregate -Pqa````
* Para filtrar la ejecución y reportes con Tags:

  ```` mvn clean verify serenity:aggregate -Pqa -Dtags="sprint-2" ````
  * Nota: Con JUnit, esto se puede lograr proporcionando un solo Tag o una lista de Tags separadas por "or".
  