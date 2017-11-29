# KenkosushiUndavBackend

Proyecto para la materia de Ingeniería de Software.
Backend de un E-commerce de Sushi hecho en Java con el framework de Spring Boot, la base de datos esta creada en MySQL.

# Instalación

git clone https://github.com/LeoGuanco/KenkosushiUndavBackend.git
cd KenkosushiUndavBackend
mvn clean install (Para instalar las dependencias)

# Creación de la base de datos

Spring Boot se encargará de crear las tablas de la base de datos pero se debe crear la misma primero. En MySQL correr el siguiente comando

CREATE DATABASE `kenko`;

# Iniciar servidor

Posicionarse en el directorio del proyecto y correr el siguiente comando

mvn spring-boot:run
