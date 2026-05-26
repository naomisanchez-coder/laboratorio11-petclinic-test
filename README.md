# LABORATORIO 11 - PRUEBAS UNITARIAS PETCLINIC

## Descripción del laboratorio

El presente laboratorio tiene como objetivo implementar pruebas unitarias dentro del proyecto `petclinic_test` utilizando Spring Boot, JUnit y Maven. Cada integrante del equipo desarrolló pruebas unitarias para distintas entidades del sistema aplicando operaciones CRUD (Create, Read, Update y Delete).

Además, se trabajó colaborativamente mediante Git y GitHub, utilizando ramas y commits para el control de versiones del proyecto.

---

# Integrantes del equipo

| Integrante | Responsabilidad |
|------------|----------------|
| Naomi Sanchez | Encargada de desarrollar el Caso 1 y Caso 2 |
| Angie Portocarrero | Encargada de desarrollar el Caso 3 |
| Sheila Diaz | Encargada de desarrollar el Caso 4 |

---

# Configuración inicial del proyecto

## Pasos realizados

1. Clonación del repositorio original:
```bash
git clone https://github.com/jgomezz/petclinic_test.git
```

2. Eliminación del historial Git original:
```bash
rm -rf .git
```

3. Inicialización del nuevo repositorio:
```bash
git init
```

4. Configuración y limpieza de credenciales del proyecto.

5. Creación del nuevo repositorio colaborativo en GitHub.

6. Invitación de colaboradoras al repositorio.

7. Ejecución del proyecto usando Maven y base de datos H2.

---

# Caso 1 - Pruebas unitarias para veterinarios (VetServiceTest)

## Descripción

En este caso se implementaron las pruebas unitarias correspondientes a la entidad `Vet` dentro de la clase `VetServiceTest`.

Para ello, se desarrollaron las siguientes clases:

- Vet
- VetRepository
- VetService
- VetServiceImpl
- VetNotFoundException

Posteriormente, se implementaron pruebas unitarias para validar las operaciones CRUD:

- Creación de veterinarios.
- Actualización de veterinarios.
- Búsqueda por ID.
- Búsqueda por nombre.
- Eliminación de veterinarios.

Finalmente, se ejecutaron correctamente las pruebas utilizando Maven y la base de datos H2.

---

## Comandos para ejecutar el Caso 1

### Ejecutar todas las pruebas

```bash
mvn test -Dspring.profiles.active=h2
```

### Ejecutar únicamente VetServiceTest

```bash
mvn -Dtest=VetServiceTest test -Dspring.profiles.active=h2
```

---

# Caso 2 - Pruebas unitarias para dueños (OwnerServiceTest)

## Descripción

En este caso se implementaron las pruebas unitarias correspondientes a la entidad `Owner` dentro de la clase `OwnerServiceTest`.

Para ello, se desarrollaron las siguientes clases:

- Owner
- OwnerRepository
- OwnerService
- OwnerServiceImpl
- OwnerNotFoundException

Posteriormente, se implementaron pruebas unitarias para validar las operaciones CRUD:

- Creación de dueños.
- Actualización de dueños.
- Búsqueda por ID.
- Búsqueda por nombre.
- Eliminación de dueños.

Finalmente, se ejecutaron correctamente las pruebas utilizando Maven y la base de datos H2.

---

## Comandos para ejecutar el Caso 2

### Ejecutar todas las pruebas

```bash
mvn test -Dspring.profiles.active=h2
```

### Ejecutar únicamente OwnerServiceTest

```bash
mvn -Dtest=OwnerServiceTest test -Dspring.profiles.active=h2
```

---

# Caso 3 - Pruebas unitarias para especialidades (SpecialtyServiceTest)

## Descripción del Caso 3 realizado por Angie Portocarrero

(Pendiente de completar)

---

## Comandos para ejecutar el Caso 3

(Pendiente de completar)

---

# Caso 4 - Pruebas unitarias para visitas (VisitServiceTest)

## Descripción del Caso 4 realizado por Sheila Diaz
### Rama: [`feature/sheila-caso4`](https://github.com/naomisanchez-coder/laboratorio11-petclinic-test/tree/feature/sheila-caso4)

Se implementaron las pruebas unitarias correspondientes a la entidad `Visit` dentro de la clase `VisitServiceTest`.

Para ello, se desarrollaron las siguientes clases:

- Visit
- VisitRepository
- VisitService
- VisitServiceImpl
- VisitNotFoundException

Posteriormente, se implementaron pruebas unitarias para validar las operaciones CRUD:

- Creación de visitas.
- Actualización de visitas.
- Búsqueda por ID.
- Búsqueda por petId.
- Eliminación de visitas.

Finalmente, se ejecutaron correctamente las pruebas utilizando Maven y la base de datos H2, obteniendo BUILD SUCCESS con 5/5 tests pasando.

---

## Pasos realizados por Sheila Diaz

### 1. Clonar el repositorio colaborativo
```bash
git clone https://github.com/naomisanchez-coder/laboratorio11-petclinic-test.git
```

### 2. Entrar a la carpeta del proyecto
```bash
cd laboratorio11-petclinic-test
```

### 3. Ver las ramas disponibles
```bash
git branch
```

### 4. Crear y cambiar a la rama del caso 4
```bash
git checkout -b feature/sheila-caso4
```

### 5. Verificar que estamos en la rama correcta
```bash
git branch
```

### 6. Ver la estructura del proyecto
```bash
dir src\main\java\com\tecsup\petclinic
dir src\main\java\com\tecsup\petclinic\entities
dir src\main\java\com\tecsup\petclinic\exceptions
dir src\main\java\com\tecsup\petclinic\services
dir src\main\java\com\tecsup\petclinic\repositories
```

### 7. Crear los archivos de producción (sin BOM para evitar error \ufeff)
```powershell
[System.IO.File]::WriteAllText("$PWD\src\main\java\com\tecsup\petclinic\entities\Visit.java", ...)
[System.IO.File]::WriteAllText("$PWD\src\main\java\com\tecsup\petclinic\exceptions\VisitNotFoundException.java", ...)
[System.IO.File]::WriteAllText("$PWD\src\main\java\com\tecsup\petclinic\repositories\VisitRepository.java", ...)
[System.IO.File]::WriteAllText("$PWD\src\main\java\com\tecsup\petclinic\services\VisitService.java", ...)
[System.IO.File]::WriteAllText("$PWD\src\main\java\com\tecsup\petclinic\services\VisitServiceImpl.java", ...)
```

### 8. Crear el archivo de pruebas
```powershell
[System.IO.File]::WriteAllText("$PWD\src\test\java\com\tecsup\petclinic\services\VisitServiceTest.java", ...)
```

### 9. Ejecutar todas las pruebas
```powershell
mvn test "-Dspring.profiles.active=h2"
```

### 10. Resultado obtenido
Tests run: 30, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
### 11. Ejecutar solo VisitServiceTest
```powershell
mvn -Dtest=VisitServiceTest test "-Dspring.profiles.active=h2"
```

### 12. Ver archivos modificados
```bash
git status
```

### 13. Agregar todos los archivos
```bash
git add .
```

### 14. Hacer el commit
```bash
git commit -m "feat: caso 4 - pruebas unitarias VisitServiceTest - Sheila Diaz"
```

### 15. Subir la rama a GitHub
```bash
git push https://SHEILA-DIAZ:ghp_TOKEN@github.com/naomisanchez-coder/laboratorio11-petclinic-test.git feature/sheila-caso4
```

### 16. Crear Pull Request en GitHub
- URL: https://github.com/naomisanchez-coder/laboratorio11-petclinic-test/pull/1
- Título: `feat: caso 4 - pruebas unitarias VisitServiceTest - Sheila Diaz`
- Rama origen: `feature/sheila-caso4`
- Rama destino: `main`
- Estado: ✅ Ready to merge - 6 archivos - No conflicts

---

## Pruebas implementadas en VisitServiceTest

| Test | Descripción | Resultado |
|---|---|---|
| `testCreateVisit` | Crea una visita y verifica que se guarda correctamente | ✅ PASS |
| `testFindVisitById` | Busca una visita por ID | ✅ PASS |
| `testUpdateVisit` | Actualiza la descripción de una visita | ✅ PASS |
| `testDeleteVisit` | Elimina una visita y verifica que no existe | ✅ PASS |
| `testFindVisitsByPetId` | Busca visitas por ID de mascota | ✅ PASS |

---

## Comandos para ejecutar el Caso 4

### Ejecutar todas las pruebas
```powershell
mvn test "-Dspring.profiles.active=h2"
```

### Ejecutar únicamente VisitServiceTest
```powershell
mvn -Dtest=VisitServiceTest test "-Dspring.profiles.active=h2"
```

---

# Dificultades encontradas y solución aplicada

Durante el desarrollo del laboratorio se presentaron algunas dificultades relacionadas con la configuración inicial del repositorio y el manejo de Git en MacOS.

Inicialmente fue necesario eliminar el historial Git del repositorio original para crear un nuevo repositorio colaborativo. Posteriormente, surgieron problemas relacionados con la autenticación de GitHub debido a que GitHub ya no permite autenticación mediante contraseña tradicional, por lo que se solucionó utilizando un Personal Access Token (PAT).

También se presentaron inconvenientes al editar commits mediante VIM desde la terminal de MacOS. Este problema fue solucionado aprendiendo el uso básico del editor para guardar y cerrar correctamente los commits.

Adicionalmente, al crear los archivos Java desde PowerShell con `Set-Content`, se generó un error de compilación por el carácter `\ufeff` (BOM). Este problema fue solucionado usando `[System.IO.File]::WriteAllText` que guarda los archivos sin BOM.

Finalmente, se verificó la correcta ejecución de todas las pruebas unitarias utilizando Maven y el perfil H2, obteniendo resultados satisfactorios con BUILD SUCCESS.

---

# Repositorio GitHub

```text
https://github.com/naomisanchez-coder/laboratorio11-petclinic-test
```