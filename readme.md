# DemoQA Automation Test

Este proyecto automatiza pruebas del formulario de práctica de DemoQA usando **Selenium WebDriver**, **JUnit 4** y **Java**.

## Estructura del Proyecto

DemoQATest/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com.demoqa/
│ │ └── Base.java # Clase base con métodos comunes y conexión WebDriver
│
│ └── test/
│ └── java/
│ └── com.demoqa/
│ ├── Formulario.java # Page Object con locators y acciones del formulario
│ └── Test_Cases.java # Clase con pruebas JUnit

markdown
Copiar
Editar

## Requisitos

- Java 8 o superior
- Maven
- ChromeDriver (configurado en el `PATH`)
- Eclipse o cualquier IDE compatible con Java

## Instalación y Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/demoqa-automation.git
   cd demoqa-automation
Asegúrate de tener ChromeDriver instalado y accesible.

Abre el proyecto en Eclipse o tu IDE favorito.

Instala las dependencias de Maven:

bash
Copiar
Editar
mvn clean install
Ejecución de las pruebas
Puedes ejecutar las pruebas desde Eclipse:

Abre Test_Cases.java

Haz clic derecho sobre el archivo y selecciona:
Run As → JUnit Test

También puedes ejecutar desde Maven:

bash
Copiar
Editar
mvn test
Funcionalidades
Automatiza el llenado de campos del formulario.

Verifica el comportamiento del formulario con campos vacíos.

Usa el patrón Page Object para mantener el código limpio y reutilizable.

Incluye funciones de scroll para interactuar con elementos fuera de vista.

Captura de pantallas (opcional).

Notas Técnicas
El método submit() incluye scroll dinámico hasta que el botón de envío esté visible.

Manejo de fechas adaptado a los campos del formulario.

Validaciones incluidas para verificar elementos presentes antes de interactuar.

Autor
Haider Fabian Arias Naranjo