DROP DATABASE IF EXISTS DB_SEIXAS;
CREATE DATABASE DB_SEIXAS;

USE DB_SEIXAS;


CREATE TABLE USUARIO (
IDUSUARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT	
, NOME VARCHAR(100)
, CPF VARCHAR(13);
, DT_NASCIMENTO DATE 
, VALOR DOUBLE
);

CREATE TABLE APOSTA (
  IDAPOSTA INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, DT_APOSTA DATE
, VALOR DOUBLE
, FOREIGN KEY IDUSUARIO (USUARIO) REFERENCES USUARIO (IDUSUARIO)	
);


