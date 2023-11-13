FROM maven:3.9.3-eclipse-temurin-17 as build

ARG JAR_PATH

WORKDIR /
ADD . .

RUN mvn clean package -DskipTests -Dcheckstyle.skip=true -Dpmd.skip=true
RUN mv /target/*.jar /app.jar

# package stage
FROM eclipse-temurin:17-jre-alpine   
WORKDIR /
# copy only the built jar and nothing else
COPY --from=build /app.jar /

EXPOSE 8080

ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE /app.jar"]