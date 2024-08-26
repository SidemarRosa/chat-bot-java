# Chatbot em Java

Este é um projeto de um chatbot desenvolvido em Java, criado para auxiliar no atendimento a clientes que desejam comprar um site.

## Funcionalidades

- Responder a perguntas frequentes dos clientes.
- Coletar informações básicas dos clientes (nome, email, tipo de site desejado, etc.).
- Orientar os clientes sobre o processo de compra de um site.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/) (opcional, para gerenciamento de dependências)

## Como Executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/chatbot-java.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd chatbot-java
    ```
3. Compile o projeto:
    ```bash
    javac -d bin src/com/exemplo/chatbot/*.java
    ```
4. Execute o chatbot:
    ```bash
    java -cp bin com.exemplo.chatbot.Chatbot
    ```

## Estrutura do Projeto

- **src/**: Contém o código-fonte Java.
  - **com/exemplo/chatbot/**: Contém as classes principais do chatbot.
- **bin/**: Diretório onde os arquivos .class compilados serão armazenados.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
