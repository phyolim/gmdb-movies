FROM openjdk:8-jdk-alpine as build
VOLUME /tmp
COPY . .
RUN ./gradlew clean build

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080

# $ docker build -t gmdb/movies[:version] .
#
# $ docker run -d -p 8200:8080 \
#         -e EUREKA_CLIENT_ENABLED=true \
#         -e EUREKA_HOST=gmdb-discovery:8761 \
#         -e DB_HOST_AND_PORT=gmdb-devdb:3306 \
#         -e DB_USER=gmdb \
#         -e DB_PWD=someGoodSecret \
#         --network gmdb-bridge \
#         gmdb/movies

