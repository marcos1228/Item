# MS de cadastro de Item
### Ferramentas utilizadas
* Intellij IDE
* Java 17
* Spring Boot
* Spring WebFlux
* Maven
* Junit Jupiter
* Mockito
* Jacoco
* Pitest
* docker-compose
* mongodb 

Todas as dependencias e versões utilizadas podem ser encontradas no arquivo de configuração do maven **pom.xml**

### Comandos  Básicos:
- *mvn spring-boot:run*: é usado para iniciar um aplicativo Spring Boot usando o Maven
- *mvn clean test*: é usado para compilar e executar os testes unitários de um projeto Java usando o Maven
- *mvn org.pitest:pitest-maven:mutationCoverage*: usado para executar testes de mutação em um projeto Java usando a ferramenta PITest (PIT - "Pitest In The House")

### Conceitos Básicos:
- **Spring WebFlux?**: é um módulo do Spring Framework que oferece suporte à programação reativa para aplicativos Java. Ele é projetado para desenvolvimento de aplicativos assíncronos e reativos, o que é especialmente útil em cenários nos quais a escalabilidade e o desempenho são fundamentais, como sistemas de alta concorrência e aplicativos em tempo real.
- **O que são testes?**
- **Testes unitários**: Verificam a menor parte testável de um software, geralmente um método ou função, isoladamente.
- **Testes de mutação**: Avalia a qualidade dos testes unitários, em teoria não há implementação extra.
- **Testes de componente**: Avalia o comportamento do software como um todo, garantindo que todos os requisitos sejam atendidos e que o software funcione corretamente no ambiente em que será executado.

### Por que testes unitários são importantes:

- **Garantir que o código funciona como esperado**:
    - Testes unitários certificam-se de que cada parte do software funciona corretamente e cumpre o seu propósito.

- **Evitar regressões**:
    - Regressões são erros que surgem após alterações no código. Testes unitários, quando executados regularmente, podem identificar rapidamente quando uma nova mudança no código quebra funcionalidades previamente estabelecidas.

- **Facilitar refatorações**:
    - Quando temos um conjunto abrangente de testes, é mais seguro fazer alterações no código, pois os testes vão alertar se alguma parte do software parou de funcionar corretamente após a refatoração.

### Testes de Mutação:

- **O que são e para que servem?**:
    - Testes de mutação aplica uma técnica que modifica o código-fonte de pequenas maneiras (criando "mutantes") e, em seguida, executa os testes unitários para verificar se eles detectam e "matam" essas mutações.

- **Conceito de "kill mutants"**:
    - "Matar" um mutante significa que os testes detectaram a mudança e falharam, o que é bom. Se os testes passarem mesmo com o código sendo modificado (mutado), isso pode indicar uma deficiência nos testes.

### Conclusão:

O objetivo deste projeto é aprimorar os meus conhecimentos em teste unitário e teste de mutação, bem como em WebFlux.

#### Autor: 
 *Marcos Barbosa EVangelista*
#### Formação:
 - *Engenheiro da computação*:
 - *Técnico em informática*:

