CREATE DATABASE JAVA;

USE JAVA;

CREATE TABLE ALUNO (
MATRICULA INT AUTO_INCREMENT,
NOME VARCHAR(50),
EMAIL VARCHAR(50),
SENHA VARCHAR(50),
PRIMARY KEY(MATRICULA)
);

INSERT INTO ALUNO VALUES (1, "CARLOS EDUARDO", "eduardo10.smart@gmail.com", "12345");

SELECT * FROM ALUNO;