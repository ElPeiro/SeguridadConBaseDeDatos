DROP TABLE IF EXISTS TBL_EMPLOYEES;
 DROP TABLE IF EXISTS  USERS;
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tipo VARCHAR(250) NOT NULL,
  raza VARCHAR (250) NOT NULL,
  color VARCHAR(250) NOT NULL,
  pelaje VARCHAR(250) DEFAULT NULL,
  fecha_nacimiento VARCHAR (250) NOT NULL,
  vacunas VARCHAR (250) NOT NULL,
  estado VARCHAR (250) NOT NULL,
  adoptivo VARCHAR (250) NOT NULL
);


CREATE TABLE USERS(
id INT AUTO_INCREMENT PRIMARY KEY,
active tinyint default '1',
password varchar(10) not null,
roles varchar(30)  not null,
username varchar(30) not null
);