CREATE DATABASE TAREA_MVC;

USE TAREA_MVC;

CREATE TABLE libro (
id_libro INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
genero_libro VARCHAR(100) NOT NULL,
fecha_libro INT NOT NULL,
nombre_libro VARCHAR(100) NOT NULL,
autor_libro VARCHAR(100) NOT NULL,
paginas_libro INT NOT NULL,
contenido_libro VARCHAR(MAX) NOT NULL);

CREATE PROCEDURE obtener_libros
AS
SELECT * FROM libro
GO;

CREATE TABLE TB_LOGIN(
id_usuario INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
usuario VARCHAR(100) NOT NULL,
pass VARCHAR(100) NOT NULL,
rol INT NOT NULL);

INSERT INTO TB_LOGIN VALUES('admin','1234',1),('lector','abcd',2);

CREATE PROCEDURE obtener_usuarios
AS
SELECT * FROM TB_LOGIN
GO;

CREATE PROCEDURE buscar_libro @palabra nvarchar(100)
AS

SELECT * FROM libro WHERE genero_libro LIKE '%'+@palabra+'%'
OR CONVERT(varchar(100),fecha_libro) LIKE '%'+@palabra+'%'
OR nombre_libro LIKE '%'+@palabra+'%' 
OR autor_libro LIKE '%'+@palabra+'%'
OR CONVERT(varchar(100),paginas_libro) LIKE '%'+@palabra+'%'
OR contenido_libro LIKE '%'+@palabra+'%' ;








