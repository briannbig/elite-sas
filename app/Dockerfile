FROM openjdk:17-slim

RUN mkdir -p /opt/elite-sas/app
COPY ./build/libs/app.jar /opt/elite-sas/app/
WORKDIR /opt/jadili/core/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]