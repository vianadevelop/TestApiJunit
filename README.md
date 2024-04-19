# automated-api-testing
Este repositório tem como objetivo a automatização de testes de API utilizando Rest Assured, Cucumber, SerenityBDD, Java, Maven e IntelliJ

* Para executar o projeto use:
```` mvn clean verify serenity:aggregate ````
* Para executar usando perfis use o parâmetro -P{env}

    ```` mvn clean verify serenity:aggregate -Pdev````

    ```` mvn clean verify serenity:aggregate -Pqa````
* Para filtrar a execução e relatórios com Tags:

  ```` mvn clean verify serenity:aggregate -Pqa -Dtags="sprint-2" ````
  * Nota: Com JUnit, isso pode ser conseguido fornecendo uma única Tag ou uma lista de Tags separadas por “ou”.
