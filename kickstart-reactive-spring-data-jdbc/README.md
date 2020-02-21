# Reactive Spring Data JDBC Example

### Project Setup
```bash
spring init\
 -n=order-service\
 -d=webflux,jdbc,lombok\
 --groupId=io.github.bhuwanupadhyay\
 --package-name=io.github.bhuwanupadhyay.order\
 --description="Order Service"\
 --version=1.0-SNAPSHOT\
 --language=java \
kickstart-reactive-spring-data-jdbc --force
```

### Knowledge
- Fundamentally JDBC API are blocking apis.
- Couple of reactive JDBC library
    - RxJdbc
    - ADBA
    - R2DBC (Reactive Relational Database Connectivity)

### R2DBC
- SPI 
    - Postgres
    - R2DBC over ADBA
         
    
