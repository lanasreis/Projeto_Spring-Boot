FROM openjdk:11

ARG PROFILE
ARG ADDITTIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITTIONAL_OPTS=${ADDITTIONAL_OPTS}

WORKDIR /opt/spring-boot

COPY /target/orangetalents*.jar orangetalents.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITTIONAL_OPTS} -jar orangetalents.jar --spring.profiles.active=${PROFILE}

