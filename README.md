# BasicAuth

Detalles:

## ARCHITECTURE MVC
```
├── controllers
│   ├── HelloController.java
│   └── AuthController.java
├── entities
│   └── User.java
├── repositories
│   └── UserRepository.java
├── security
│   ├── UserDetailServiceImpl.java
│   └── WebSecurityConfig.java
├── services
│   ├── UserService.java
├── config
│   └── SwaggerConfig.java
── test
    ├── controllers
    │  └── HelloController.java
    └── repositories
       └── UserRepositoryDataJpaTestIT.java


```

https://jwt.io

Es un estandar abierto que permite transmitir informacion entre dos partes:

JSON web Token
### Funcionamiento Session
1. Cliente envia una peticion a un servidor (/login)
2. Servidor valida el username y la password, Si no son validos devolvera una respuesta 401 unauthorized
3. Servidor valida el username y la password, Si son validos entonces se almacena el usuario en session
4. Se genera una cookie en el Cliente
5. En proximas peticiones se comprueba que el cliente esta en session

Desventajas:

* La informacion de la session se almacena en el servidor, lo cual consume recursos.



## TEST DE INTEGRACION
Utilizo Spring test
### TestRestTemplate
1.  Spring Anotation
```java
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
```
2. Headers
```java
    private final HttpHeaders headers = new HttpHeaders();

```
3. Objects
```java
    private final RegisterRequest registerRequest = new RegisterRequest();
    private final LoginRequest loginRequest = new LoginRequest();
```
1.  Templeate and Port
```java
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

```
2. Build
```java
    @BeforeEach
    public void setUp(){
        restTemplateBuilder = restTemplateBuilder.defaultHeader("Authorization","sd")
                .rootUri("http://localhost:"+port);
        testRestTemplate= new TestRestTemplate(restTemplateBuilder);
        headers.add("Authorization", "laptop-value-45xx23");
    }
```
### @DataJpaTest
1. Anotación
```java
  @DataJpaTest
```
2. Uso de metodos JPA
```java
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;
```
### Services y Controllers
* register
    * register
    * registerNull
    * register_Set_Null
    * register_UserExist
    * register_EmailExist
* login
    * login
    * loginNull
* save (Entity2)
    * save
    * saveNull
    * saveUnauthorized
* findAll (Entity2)
    * findAll
    * findAllNull
    * findAllUnauthorized
* findOne (Entity2)
    * finOne
    * findOneNullId
    * findOneUnauthorized
* update (Entity2)
    * update
    * updateNull
    * updateUnauthorized
* delete (Entity2)
    * delete
    * delteNullId
    * deleteUnauthorized

_No se incluiran en el proyecto: Recuperacion de contraseña ni de usuario_


## CONFIG SPRING

Crear proyecto Spring Boot con:

* Spring 2.5.5
* Spring Security
* Spring Web
* Spring boot devtools
* Spring Data JPA
* H2
* Swagger (manual)
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```


* PROPERTIES (H2 y JWT)
```
#Preparo e Inicializo H2
spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:file:C:/data/sample
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

#Configuro JWT
app.jwt.secret=openb
app.jwt.expiration-ms=86400000

```
## ERRORES

# Licencia

```xml
Designed and developed by 2023 adrian-reh (Adrian Ramon Elias Herrera)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
