# especialista_integracion_bci
especialista_integracion_bci

# Evaluación: API RESTful de Creación de Usuarios

## Descripción

Esta aplicación es una API RESTful construida en Java para gestionar la creación de usuarios. La API permite registrar usuarios en la base de datos, persistir tokens de autenticación (JWT) y realizar validaciones de los datos de entrada. La aplicación está configurada para trabajar con una base de datos en memoria H2.

Todos los endpoints aceptan y devuelven JSON, incluyendo los mensajes de error en el formato:
json
{"mensaje": "mensaje de error"}


Funcionalidades
Registro de Usuarios: Permite registrar un usuario con los campos nombre, correo, contraseña y una lista de teléfonos.
Validaciones de Correo y Contraseña: El correo debe seguir el formato aaaaaaa@dominio.cl y la contraseña debe cumplir con una expresión regular configurada en application.properties.
Respuesta con Detalles del Usuario: Al registrar un usuario exitosamente, la respuesta incluye los campos id, created, modified, last_login, token, y isactive.
Manejo de Errores: Si el correo ya está registrado o los datos no cumplen con las validaciones, la API devuelve un mensaje de error específico.


Requisitos
Java 17
Maven para manejar dependencias
H2 en memoria para la base de datos


Instalación
1.Clonar el repositorio:

git clone https://github.com/tu-usuario/tu-repositorio.git

2.Compilar y construir la aplicación:
mvn clean install

3.Ejecutar la aplicación:
mvn spring-boot:run


La aplicación se ejecutará en http://localhost:8080.



para consumir el servicio de crear usuario se debe crear un token  consuminedo el siguiente servicios 

Post http://localhost:8080/auth/auth/token

Body:

{
  "nombreUsuario": "prueba",
  "password": "prueba123"
}


response:

{
  "status": 200,
  "message": "Token generado exitosamente",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmEiLCJleHAiOjE3MzE1OTkyMDYsImlhdCI6MTczMTU5NTYwNiwicm9sIjp7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9fQ.s92cBur6frXihWWExA3Y5sGT7pd32Gi1PJrwlgMmVoU",
    "codigo": 1
  }
}  


se toma el token el cual se debe enviar con Bearer token


Endpoints
Registro de Usuario
URL: POST /api/usuarios/registro

Formato de Entrada:
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}


Formato de Respuesta en Caso de Éxito (HTTP 201):


{
    "id": "1103962e-adf7-463a-9279-5e44e3546f17",
    "name": "Juan manuel",
    "email": "juanddmsde@gmail.com",
    "password": "Abc123$xyz",
    "created": "2024-11-14T09:04:40.9720049",
    "modified": "2024-11-14T09:04:40.9720049",
    "lastLogin": "2024-11-14T09:04:40.9720049",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmEiLCJleHAiOjE3MzE1OTY2ODEsImlhdCI6MTczMTU5MzA4MSwicm9sIjp7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9fQ.KNQEoSC_EdXNpGyMaxXiZ7OqRW0001T0_EnJLNtcagM",
    "isActive": true,
    "phones": [
        {
            "number": "2",
            "citycode": "4",
            "contrycode": "7"
        }
    ]
}


Formato de Respuesta en Caso de Error (HTTP 400):

{"mensaje": "El correo ya registrado"}


Validaciones
Correo Electrónico: Debe seguir el formato aaaaaaa@dominio.cl. Si el formato es incorrecto, se devuelve:

json
Copiar código
{"mensaje": "El formato del correo electrónico es inválido"}
Contraseña: Debe cumplir con la expresión regular configurada en application.properties. Si no cumple, se devuelve:

json
Copiar código
{"mensaje": "La contraseña no cumple con el formato requerido"}
Correo Duplicado: Si el correo ya existe en la base de datos, se devuelve:

json
Copiar código
{"mensaje": "El correo ya registrado"}
Configuración
La configuración de la base de datos H2 y las expresiones regulares se encuentran en src/main/resources/application-dev.properties.

Expresiones Regulares:

properties

password.regex= ^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$

email.regex= ^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$


Configuración de H2:

properties
Copiar código
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Acceso a la Consola H2
Puedes acceder a la consola de H2 en http://localhost:8080/h2-console     usando:

URL JDBC: jdbc:h2:mem:testdb
Usuario: sa
Contraseña: password


Ejemplo de Prueba con curl
Para probar el registro de un usuario:

bash

curl -X POST http://localhost:8080/api/usuarios/registro -H "Content-Type: application/json" -d '{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "hunter2",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}

Notas
Asegúrate de que los datos de entrada cumplen con las validaciones para evitar errores.
La contraseña y el correo electrónico deben ajustarse a las expresiones regulares configuradas.
Autores
Carlos Andres Caicedo camilo
Este README proporciona todos los detalles necesarios para instalar, ejecutar y probar la aplicación, así como información de configuración relevante.


