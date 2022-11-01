# todoApp
TodoApp - Task Control

1. Linguagem Utilizada: JAVA
2. Banco Dados : Mysql
3. Padrão de Projeto: MVC

Aplicativo para gerenciamento de Porjetos/Tarefas  codificado em JAVA. A aplicaçõa permite realizar o cadastro de projetos e suas tarefas.
<p align="center">
<img src="https://user-images.githubusercontent.com/99821361/199311840-145890a8-11fe-40e7-8f3f-bef4d5ba914b.png">
</p>
<p align="center">
<img src="https://user-images.githubusercontent.com/99821361/199311902-5e8a49b7-16e0-484f-ad5e-883417b81812.png">
<img src="https://user-images.githubusercontent.com/99821361/199311861-45b87157-9f87-4cc5-abd1-3f1125ecf887.png">
</p>




 ```bash
Para rodar a aplicação você pode:

1- Clone o  repositório: Git clone https://github.com/dsfilho/todoApp

2- Executar o Scipt: todoAppBD.sql, localizado na pasta DB do projeto, no seu SGBD.

3- Realiza a configuração conforme no arquivo ConnectionFactory.java informado abaixo.


#CONFIGURAÇÕES NECESSÁRIAS NO ARQUIVO: util/ConnectionFactory.java

     String DRIVER =  "com.mysql.cj.jdbc.Driver";
     String URL = "jdbc:mysql://ENDERECO_SERVIDOR_BANCO_DADOS:3306/NOME_BANCO_DADOS";
     String USER = "USUARIO_BANCO_DADOS";
     String PASSWORD = "SENHA_BANCO_DADOS";
     
 4- Rodar o projeto em sua IDE preferida.



