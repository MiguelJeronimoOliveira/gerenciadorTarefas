# Gerenciador de tarefas

#### A) - Aplicação Java Web utilizando JavaServer Faces (JSF).

#### B) -  Persistência em um banco de dados PostgreSQL.

#### C) - Utilização de JPA através do Hibernate.

#### D) - Utilização de testes unitarios com Junit5.

#### F) Sessão de usuario
Sistema de SingUp e Login com interface unica para cada usuario.

## Ambiente local utilizado
- iDE Eclipse
- JDK 8
- Servidor Apache Tomcat 8.5
- PostgreSQL (mais recente)
- Projeto Maven
- JavaServer Faces 2.3
- JPA 2.1
- Hibernate 5.4.0.Final

- ### Passos para a instalação local
1. Clone o repositório ou baixe o arquivo compactado em .zip e descompacte;
2. Abra o projeto no Eclipse;
3. Restaure as dependências com o Maven. Para isso, navegue para `Project > Update Maven Project`;
4. Configure o compilador Java. Para isso, navegue para `Project > Properties > Java Compiler` e certifique-se de estar configurado para 1.8;
5. Acesse o arquivo `persistence.xml` no diretório `src/main/java/META-INF` e configure as propriedades de conexão com o banco desejado;
6. Navegue para `Project > Properties > Server` e configure o Apache Tomcat 8.5;
7. Em Project Explorer, clique com o botão direito do mouse sobre o projeto e clique em `Run As > Run on Server`.
