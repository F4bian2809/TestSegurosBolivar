# TestBolivar

Este repositorio contiene un proyecto de automatización de pruebas, probablemente desarrollado con Selenium/WebDriver y Java, utilizando Maven como herramienta de gestión de proyectos.

## Estructura del Proyecto

La estructura principal del proyecto es la siguiente:

TestBolivar/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── demoqa/
│       │           ├── Base.java
│       │           ├── Formulario.java
│       │           └── Test_Cases.java
│       └── resources/
│           └── chromedriver/
├── JRE System Library [JavaSE-1.8]
├── Maven Dependencies
├── allure-results/
├── src/
│   ├── main/
│   └── test/
├── target/
└── pom.xml


### Descripción de Directorios y Archivos Clave:

* **`src/main/java`**: Contendrá el código fuente principal de la aplicación si este fuera un proyecto de aplicación, pero en un proyecto de pruebas a menudo está vacío o contiene clases de utilidad.
* **`src/main/resources`**: Recursos de la aplicación.
* **`src/test/java`**: Contiene el código fuente de las pruebas automatizadas.
    * **`com.demoqa/`**: Paquete donde se encuentran las clases relacionadas con las pruebas.
        * **`Base.java`**: Probablemente una clase base que contiene configuraciones iniciales, métodos de inicialización de WebDriver, o configuraciones comunes para todas las pruebas.
        * **`Formulario.java`**: Podría representar una clase Page Object Model (POM) para un formulario específico en el sitio web de prueba (probablemente `demoqa.com`). Contendría localizadores de elementos y métodos para interactuar con el formulario.
        * **`Test_Cases.java`**: Contiene los métodos de prueba reales que utilizan las clases `Base.java` y `Formulario.java` para ejecutar los escenarios de prueba.
* **`src/test/resources/chromedriver`**: Contiene el ejecutable del ChromeDriver, necesario para automatizar pruebas en el navegador Google Chrome.
* **`JRE System Library [JavaSE-1.8]`**: Indica que el proyecto está configurado para usar Java SE 1.8.
* **`Maven Dependencies`**: Las bibliotecas y dependencias que Maven descarga y gestiona para el proyecto.
* **`allure-results/`**: Directorio donde se generan los resultados de las pruebas, presumiblemente para ser utilizados con el generador de informes Allure.
* **`target/`**: Directorio donde Maven compila el código y coloca los artefactos de construcción (clases compiladas, archivos JAR/WAR, etc.).
* **`pom.xml`**: El archivo de configuración principal de Maven. Define las dependencias del proyecto, los plugins, la configuración de construcción y otra información del proyecto.

## Requisitos

* Java Development Kit (JDK) 8 o superior.
* Maven.
* Google Chrome (para las pruebas de UI).

## Configuración del Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/F4bian2809/TestSegurosBolivar.git
    cd TestBolivar
    ```
2.  **Instalar dependencias de Maven:**
    Maven debería descargar automáticamente las dependencias cuando el proyecto sea importado en un IDE o cuando se ejecuten comandos de Maven.
    ```bash
    mvn clean install
    ```

## Ejecución de Pruebas

Para ejecutar las pruebas desde la línea de comandos, puedes usar Maven:

```bash
mvn test
Generación de Informes Allure
Si Allure Report está configurado, puedes generar los informes de la siguiente manera (asegúrate de tener Allure Commandline instalado):

Ejecutar las pruebas para generar los resultados de Allure:
Bash

mvn test
Generar el informe Allure y abrirlo en el navegador:
Bash

allure serve allure-results
Contribución
Si deseas contribuir a este proyecto, por favor, sigue las siguientes pautas:

Haz un "fork" del repositorio.
Crea una nueva rama para tus cambios (git checkout -b feature/nombre-de-la-caracteristica).
Realiza tus cambios y commitea (git commit -m 'feat: añade nueva característica').
Empuja tus cambios a tu "fork" (git push origin feature/nombre-de-la-caracteristica).
Abre un "pull request" al repositorio original.
