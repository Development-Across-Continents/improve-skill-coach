# improve-skill-coach

### Configs

application.properties

```
server.port=8085
spring.profiles.active=${APP_PROFILE:test}
```

application-test.properties

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

application-dev.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/improve_skill
spring.datasource.username=${USER_NAME}
spring.datasource.password=${PASSWORD}

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

### Diagram

<div align="center">
  <img src="https://thumbs2.imgbox.com/d3/9a/gUOJuR76_t.png" />
</div>
