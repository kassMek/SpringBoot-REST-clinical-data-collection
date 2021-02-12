
FROM java:8
ADD target/clinical-restful-data-collection-0.0.1-SNAPSHOT.jar clinical-restful-data-collection-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","clinical-restful-data-collection-0.0.1-SNAPSHOT.jar"]
