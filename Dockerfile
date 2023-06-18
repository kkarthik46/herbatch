From openjdk:8
EXPOSE 8088
Add target/springmvcjpa-0.0.1-SNAPSHOT.war springmvcjpa-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/springmvcjpa-0.0.1-SNAPSHOT.war"]