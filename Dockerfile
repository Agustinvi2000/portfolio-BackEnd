#de que imagen partimos
FROM amazoncorretto:17-alpine-jdk 

#quien es el dueño

MAINTAINER AVI 

#va a copiar el empaquetado a github (el empaquetado es el archivo (nombre proyecto)-0.0.1-SNAPSHOT.jar que esta en la carpeta target --> si no lo tengo hago Clean and Build)
COPY target/portfolio-0.0.1-SNAPSHOT.jar  portfolio-backend.jar

#es la instruccion que se va a ejecutar primero 
ENTRYPOINT ["java","-jar","/portfolio-backend.jar"] 