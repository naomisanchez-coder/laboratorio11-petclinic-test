# LABORATORIO 11 - PRUEBAS UNITARIAS CON PETCLINIC

## Descripción del laboratorio

En el presente laboratorio se desarrollaron pruebas unitarias sobre el proyecto `petclinic_test` utilizando Spring Boot, Maven, JUnit y base de datos H2.

Cada integrante del equipo trabajó sobre una entidad distinta aplicando operaciones CRUD (Create, Read, Update y Delete), además del uso de Git y GitHub para el trabajo colaborativo.

---

# Integrantes del equipo

| Integrante | Responsabilidad |
|---|---|
| Naomi Sanchez | Caso 1 y Caso 2 |
| Angie Portocarrero | Caso 3 |
| Sheila Diaz | Caso 4 |

---

# Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- JUnit 5
- Mockito
- H2 Database
- Git y GitHub
- IntelliJ IDEA

---

# Configuración inicial del proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/naomisanchez-coder/laboratorio11-petclinic-test.git
```

---

## 2. Ingresar a la carpeta del proyecto

```bash
cd laboratorio11-petclinic-test
```

---

## 3. Abrir el proyecto en IntelliJ IDEA

Abrir la carpeta del proyecto desde IntelliJ IDEA y esperar que Maven descargue las dependencias automáticamente.

---

## 4. Verificar la versión de Java

```bash
java -version
```

---

## 5. Ejecutar las pruebas unitarias

```bash
mvn test
```

---

# Caso 3 - Pruebas unitarias para especialidades

## Descripción

En este caso se implementaron las pruebas unitarias correspondientes a la entidad `Speciality` dentro de la clase `SpecialityServiceTest`.

Para ello, se desarrollaron las siguientes clases:

- Speciality
- SpecialityDTO
- SpecialityRepository
- SpecialityService
- SpecialityServiceImpl
- SpecialityMapper
- SpecialityNotFoundException

Posteriormente, se implementaron pruebas unitarias para validar las operaciones CRUD:

- Creación de especialidades
- Actualización de especialidades
- Búsqueda por ID
- Búsqueda por nombre
- Eliminación de especialidades

Finalmente, se ejecutaron correctamente las pruebas utilizando Maven y la base de datos H2 obteniendo `BUILD SUCCESS`.

---

# Estructura implementada

```text
src/main/java/com/tecsup/petclinic
│
├── dtos
│   └── SpecialityDTO.java
│
├── entities
│   └── Speciality.java
│
├── exceptions
│   └── SpecialityNotFoundException.java
│
├── mappers
│   └── SpecialityMapper.java
│
├── repositories
│   └── SpecialityRepository.java
│
└── services
    ├── SpecialityService.java
    └── SpecialityServiceImpl.java
```

---

# Pruebas implementadas

| Test | Descripción | Resultado |
|---|---|---|
| `testFindSpecialityById` | Busca una especialidad por ID | PASS |
| `testFindSpecialityByName` | Busca especialidades por nombre | PASS |
| `testCreateSpeciality` | Registra una nueva especialidad | PASS |
| `testUpdateSpeciality` | Actualiza una especialidad | PASS |
| `testDeleteSpeciality` | Elimina una especialidad | PASS |

---

# Comandos utilizados

## Ejecutar todas las pruebas

```powershell
mvn test
```

## Ejecutar únicamente SpecialityServiceTest

```powershell
mvn -Dtest=SpecialityServiceTest test
```

---

# Resultado final

```text
Tests run: 20
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# Repositorio GitHub

```text
https://github.com/naomisanchez-coder/laboratorio11-petclinic-test
```

---

# Conclusión

Durante el desarrollo del laboratorio se logró implementar correctamente las pruebas unitarias para la entidad `Speciality`, validando las operaciones CRUD mediante Spring Boot, JUnit y H2 Database.

Además, se reforzó el uso de GitHub para el trabajo colaborativo y el control de versiones dentro del equipo.