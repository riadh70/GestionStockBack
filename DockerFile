FROM openjdk:11
EXPOSE 8089
ADD target/gestiondestock-0.0.1-SNAPSHOT.jar gestiondestock.jar
ENTRYPOINT ["java","-jar","/gestiondestock.jar"]
