# Theatre System
## Requirements
- MySQL
- Java 21
- Maven
## Create Database
Login into MySQL: `mysql -u root -p`
Create database:
```sql
CREATE USER 'ensf480'@'localhost' IDENTIFIED BY 'ensf480';
CREATE DATABASE theater480;
GRANT ALL PRIVILEGES ON *.* TO 'ensf480'@'localhost' with GRANT OPTION;
```
## Running the program
`mvn spring-boot:run`
## Target
Visit [localhost:8080](http://localhost:8080) in a local browser
