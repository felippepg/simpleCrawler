# Simple Crowler
O projeto é um Crawler simples onde é possivel consultar uma página web e buscar informações do mesmo.

### 🔨 Ferramentas

- Java
- Spring MVC
- Jsoup
- Bootstrap

### 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [Git](https://git-scm.com).
- [Java](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)

Além disto é bom ter um editor para trabalhar com o código como [VsCode](https://code.visualstudio.com/)
,[Intellij](https://www.jetbrains.com/pt-br/idea/) ou [Eclipse](https://www.eclipse.org/downloads/).

### 🎲 Rodando a Projeto

```bash
# Clone este repositório
$ git clone <https://github.com/felippepg/simpleCrawler.git>

# Acesse a pasta do projeto no terminal/cmd
$ cd simpleCrawler

# Baixar todas as dependencias do pom.xml antes de rodar o projeto

# Executar a classe SimpleCrawlerApplication

# Endereço padrão http://localhost:8080
```

### ✏️ Observações 
Não foi possível obter os dados paginados da seção Mercados do site [Infomoney](https://www.infomoney.com.br/mercados/), pois não consegui simular interações usando o Jsoup.

Ao pesquisar sobre a implementação, encontrei maneiras de fazer isso usando o Selenium WebDrivers. No entanto, isso exigiria configurar
um driver para cada navegador usado ao executar a aplicação (e versões de navegador e drivers). Estou aberto e interessado em aprender como implementar isso.

Obrigado 🙏


