create dataBase empleadosnominas;
USE empleadosnominas;
CREATE TABLE Empleado (
    Nombre VARCHAR(25) not null,
    Dni VARCHAR(9) PRIMARY KEY,
    Sexo CHAR(1) not null,
    Categoria INT(10) not null default 1,
    Anyos INT(10) not null default 0
);

CREATE TABLE Nomina (
    Dni varCHAR(9) PRIMARY KEY,
    sueldo int(20)
);

INSERT INTO empleado(nombre,dni,sexo,categoria,anyos) VALUES ('Ada Lovelace','32000031R','F',2,6);
INSERT INTO empleado(nombre,dni,sexo,categoria,anyos) VALUES ('James Cosling','32000031G','M',4,7);
INSERT INTO empleado(nombre,dni,sexo,categoria,anyos) VALUES ('Jessy','87654321K','F',3,9);
INSERT INTO empleado(nombre,dni,sexo,categoria,anyos) VALUES ('Dolores','54321678C','F',4,2);

INSERT INTO nomina(dni,sueldo) VALUES ('32000031R',39000);
INSERT INTO nomina(dni,sueldo) VALUES ('32000031G',48000);
INSERT INTO nomina(dni,sueldo) VALUES ('87654321K',56000);
INSERT INTO nomina(dni,sueldo) VALUES ('54321678C',23000);