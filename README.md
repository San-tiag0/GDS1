# GDS1
Proyecto "DrawYourRoute", de Gestión del Software 1, grupo 5, cuyos integrantes son Jesús Alberto Lárez Romero, Ignacio José Marín Reyes, Saulo Santana Batista,
Luis Enrique Galindo Molina, y Santiago Higuita Ardila.

La aplicación propuesta que llamamos “DrawYourRoute”, se encarga de replicar un dibujo en el mapa, para ello, el trazo de la ruta está basado en nuestra ubicación en 
GPS en distintos instantes de tiempo. La aplicación nos muestra un dibujo concreto y nosotros tendremos que replicarlo en el mapa a través de nuestros desplazamientos, 
cuanto más aproximado sea nuestra ruta con el dibujo a copiar, mayor puntuación obtendremos.  

Con respecto a las tecnologías utilizadas, como lenguaje de programación utilizamos Java para el backend y el framework de Ionic para el frontend. 
También, utilizamos la tecnología de la Java API Restfull Web Services para la creación de servicios REST, es decir, seguimos una arquitectura REST. Por otro lado,
como sistema de gestión de bases de datos utilizamos MYSQL y como servidor de aplicaciones Payara.

El diagrama de clases de la aplicación lo representamos a continuación:

![Diagrama clases](https://raw.githubusercontent.com/San-tiag0/GDS1/master/gs1pr/DrawYourRoute_model.png)

Las funcionalidades principales que ofrece el prototipo son las siguientes: 

- Registro de nuevos usuarios. 
- Inicio de sesión de usuarios. 
- Búsqueda de usuarios de la aplicación por su alias o nickname. 
- Posibilidad de tener una lista de amigos dentro de la aplicación. 
- Los usuarios pueden crear un modelo de dibujo. 
- Los usuarios pueden seguir un dibujo creando una ruta propia. 
- Los usuarios pueden ver las rutas de sus amigos. 
- Los usuarios pueden ver las rutas de los demás usuarios dentro de la aplicación. 
- Los usuarios pueden ver todos sus dibujos y rutas realizados anteriormente. 
- La aplicación calcula una puntuación cuando el usuario hace una ruta en base al dibujo elegido. 
- Los usuarios pueden dar “like” o “me gusta” a rutas de otros usuarios. 
- Los usuarios pueden ver un ranking con las 10 rutas que poseen mayor número de “likes”.

El siguiente enlace redirecciona al video de demostración del funcionamiento del prototipo:  

[Demostración aplicación](https://youtu.be/7PhFTkIolnI)

