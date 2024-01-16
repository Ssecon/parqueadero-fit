# parqueadero-fit
##  Objetivo:
Desarrollar un microservicio que gestione el módulo de Registrar un vehículo al parqueadero.

### El módulo de registro debe permitir:
- Agregar un vehículo (placa/patente, color, marca, dueño, modelo, hora entrada)
- Borrar un vehículo (placa/patente)
- Actualizar información del vehículo
- Mostrar la lista de vehículos agregados y/o información de un vehiculo
## SQL

Se ejecutan los siguientes scripts para la creacion de la tabla y bbdd.


Motor de base de datos elegido: MySQL

``` sql
CREATE DATABASE VEHICULOS;
```
``` sql
USE VEHICULOS;
```
``` sql
CREATE TABLE VEHICULO_INFO (
    ID INTEGER PRIMARY KEY  AUTO_INCREMENT,
    PATENTE VARCHAR(255) UNIQUE NOT NULL,
    COLOR VARCHAR(255) NOT NULL,
    MARCA VARCHAR(255) NOT NULL,
    DUEÑO VARCHAR(255) NOT NULL,
    MODELO VARCHAR(255) NOT NULL,
    HORA_ENTRADA DATETIME NOT NULL
);
```