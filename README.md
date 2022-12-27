# Introducción

Mockito es un framework de pruebas unitarias que se integra facilmente con JUnit y es útil para simular el comportamiento de terceros (dependencias) en las pruebas. Permite testear componentes complejos que dependen de otros componentes sin necesidad de montar todos estos escenarios (emular dependencias sin necesidad de configurarlas).

# ¿Qué proporciona Mockito?
* Permite escribir y ejecutar escenarios de test
* Simula el comportamiento de componente4s
* Proporciona rapidez en las pruebas
* Útil para seguir el paradigma TDD/BDD

Ejemplos de componentes simulados:
* Conexiones con bdd
* Servicios web
* Clases de lenta ejecución
* Clases con side effects (efectos secundarios)
* Clases con un comportamiento indefinido

Mockito permite basarnos en el comportamiento de otros componentes:
* Dado que (given): preparacion estado inicial
* Cuando (when): se invoca el metodo
* Entonces (then): validamos el comportamiento esperado

# Primeros Mocks
Creamos un proyecto maven e importamos las librerías de JUnit y Mockito:
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.1</version>
        <scope>test</scope>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>4.8.1</version>
        <scope>test</scope>
    </dependency>

</dependencies>
```

Creamos en la carpeta test un paquete donde estarán nuestros test y una clase de test:
```java
package com.example.unidad1;

public class MockTest {

}
```

Creamos un test (podemos hacerlo con la opción Generate de intelliJ):
```java
@Test
void test() {
    // given
    // when
    // then
}
```
Para que funcione debe estar importada la dependencia de junit:
```java
import org.junit.jupiter.api.Test;
```
Hasta ahora, el contenido de la clase MockTest es el siguiente:
```java
package com.example.unidad1;

import org.junit.jupiter.api.Test;

public class MockTest {

    @Test
    void test() {
        // given
        // when
        // then
    }
}
```

Dentro de la clase, antes del test, configuramos los test. Por un lado definimos la dependencia y el sistema bajo test (clase que utiliza la dependencia):
```java
Dependencia dependencia;
SistemaBajoTest sistemaBajoTest;
```

Creamos ahora un método BeforeEach donde configuramos la dependencia con mockito:
```java
@BeforeEach
void setUp() {
    dependencia = mock(Dependencia.class);
    sistemaBajoTest = new SistemaBajoTest(dependencia);
}
```

Para que funcione debe estar importada como `static` la dependencia de mockito:
```java
import static org.mockito.Mockito.mock;
```

Ya tenemos configurado el primer mock, listo para usarse en un escenario `given`-`when`-`then`:
```java
@Test
void test() {
    // given - Cuando el método de esta dependencia mockeada sea llamado, debe retornar "valor"
    when(this.dependencia.metodo()).thenReturn("valor");

    // when - Probamos el escenario
    Object valorRetornado = this.service.metodo();

    // then
    assertEquals("valor", valorRetornado);
}
```
