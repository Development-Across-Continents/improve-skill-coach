# improve-skill-coach

### About

This project is about a coaches and clients to improve their skills


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

### HTTP Serialização JSON

<div align="center">
  <img src="https://media.discordapp.net/attachments/1201936402322046978/1214717460335562752/image.png?ex=65fa20ca&is=65e7abca&hm=54343701e71a95a4996d2f76b7b828b6e53f9f2bae95fa0d9c68c6765a6b7c19&=&format=webp&quality=lossless&width=1439&height=537"/>
</div>
