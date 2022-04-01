<h1 align="center"> Projeto_API_RESTfull_Carros </h1>
Adaptação do projeto mostrado no curso API RESTful com SpringBoot do Ricardo R. Lecheta na Udemy, aplicando conhecimentos de docker para adaptação da utilização do banco de dados

Dependencias Spring Initializr
* Spring Web
* Spring dev tools

Criando o banco de dados no docker
* sudo docker run -p 3306:3306 --name carros-db -e MYSQL_ROOT_PASSWORD=root -d mysql --default-authentication-plugin=mysql_native_password -h 127.0.0.1
  -> o primeiro comando usado foi : sudo docker run --name carros-db -p 33060:33060 -e MYSQL_ROOT_HOST='%' -e MYSQL_ROOT_PASSWORD='root' -d mysql/mysql-server:latest
  -> Porém na hora de fazer a conexão o programa não funcionava, trocando pelo comando acima como encontrado na internet funcionou
* nome do container: carros-db
* -d : mantem o container rodando
* -p : define a porta
* -e : por ser imagem oficial suporta as variaveis de ambiente definidas após o "e"
* nome do usuario do banco: root
* password do banco: root
* imagem: mysql

ACESSANDO O MYSQL PELO CONTAINER E POPULANDO O BANCO
* Para acessar o banco: sudo docker exec -it carros-db mysql -u root -p root
* Create database carros_teste
* Para criar tabela e popular pegar referencia: https://github.com/rlechetaudemy/carros_springboot/tree/master/%20mysql
