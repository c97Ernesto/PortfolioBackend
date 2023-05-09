FROM amazoncorreto:17

MAINTAINER ernesto

COPY target/ernesto-0.0.1-SNAPSHOT.jar ernesto-0.0.1-SNAPSHOT.jar
 
ENTRYPOINT ["java","-jar","/ernesto-0.0.1-SNAPSHOT.jar"]

