# Introducción

A lo largo del módulo vamos a trabajar siempre del mismo modo.
Los ejemplos y ejercicios resueltos, os los voy a colgar en un repositorio de GITHUB para disponer de un fácil acceso a los ejemplos y ejercicios.

El repositorio del módulo es:  [Repositorio](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files)

En este repositorio iré colgando a lo largo del curso, los siguientes temas y ejercicios, por lo que a la vez que vamos viendo temas, en paralelo también trabajamos con GIT.

Para trabajar con GIT, inicialmente, lo haremos desde un programa para facilitar su uso. Si no tenéis ninguno o recomiendo por ahora, [GITHUB Desktop](https://desktop.github.com/), ya que es muy sencillito.
Más adelante, utilizaremos otros, como [SourceTree](https://www.sourcetreeapp.com/) o [SmartGit](https://www.syntevo.com/smartgit/).

## Tema 1. Material disponible

Para este tema de ficheros disponéis de bastantes recursos colgados en classroom.

Apuntes principales: (Classroom Tema1: Ficheros / Apuntes del tema)
 - [AAD. Tema01. Ficheros.pdf](https://drive.google.com/open?id=14QR19HCs0huVhDnDJXhoMQy4baS1z55vNjiFLECne6k)
 De este fichero principalmente la primera parte, hasta las estructuras de datos. Las estructuras de datos son muy importantes para cualquier programa, y para el trabajo con ficheros también.
 - [UD1. Java.io y NIO](https://drive.google.com/open?id=13b6O0JDtKKexTGOf9chiV0_yHTjfkIEk)
 Presentación de los conceptos del JAVA.IO y NIO muy clara, solo exponiendo las clases fundamentales para el trabajo con ficheros. También incluye la NIO y el trabajo con la API Stream.
 
- [UD1-Ficheros-Completa.pdf](https://drive.google.com/open?id=1WbctICiyEJIUXr1Cc2VN5bGeKjXyAU2d)
Documento con apuntes más conceptuales sobre ficheros, su evolución, para qué se utilizan, qué tipos hay, y hace un recorrido sobre el paquete JAVA.IO de java.  Este documento principalmente para teoría. 

> A este documento se le han eliminado enlaces que no funcionaban. El código fuente de los ejemplos están en el repositorio de GITHUB, aunque cuando pueda se las iré incluyendo allí

Ampliación del tema: (Classroom Tema1: Ficheros / Ampliación del Tema-1)
- [Apuntes Java IO y NIO.pdf](https://drive.google.com/open?id=1hqkLWbBooCjv5AKzdVH4S2re3BKXhHQf&authuser=2)
Apuntes elaborados desde un tutorial de java (al cual tenéis acceso a través de los muchos enlaces en el mismo).
IDEA: sirvan como referencia, además de que se explican muy bien los conceptos sobre la forma tradicional de manejo de ficheros en java (java.io) y la nueva forma, incluida a partir de la versión 7 (java.nio).   DEBÉIS LEERLOS.

## Ficheros.  Ejercicios Resueltos

#### Primeros pasos
Lo primero, clonar el repositorio para que podáis ver los ejemplos en vuestro equipo, y abrirlos con Eclipse o Intellij.

```bash
git clone https://github.com/jssdocente/AAD.git
```
> Esta orden la tenéis que ejecutar en el directorio donde queráis que esté el código fuente en vuestro equipo.


### Estructura del repositorio para Tema1

Se estructura en carpetas que tratan cada uno, los puntos importantes del trabajo con ficheros en java. 

-	**ConfigFiles**:   [Trabajo con ficheros de configuración](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/ConfigFiles) 
-	**flujos**:  Trabajo con flujos
	- Entrada: [ejemplos con flujos de entrada](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/flujos/entrada)
	- Salida: [ejemplos con flujos de salida](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/flujos/salida)
 -	**Clase File**:  [Trabajo con la clase File de java](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/claseFile)
 -	**Clase Files**: [Trabajo con la clase Files de java](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/claseFiles)
 -	**clasePath**:  [Trabajo con la clase Path](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/claseFiles)
 -	**nio**:  Ejemplos con NIO (new IO)
	-	**API-Stream**:  [Ejemplos con NIO y API Stream](https://github.com/jssdocente/AAD/tree/main/Tema1/Tema1_Files/src/tema1/nio/apiStream) (esto aún no lo hemos visto, lo iremos viendo a lo largo del curso).
- **Ejemplos**:  [Aquí están los ejemplos donde se unen todo lo aprendido](https://github.com/jssdocente/AAD/blob/main/Tema1/Tema1_Files/src/tema1/_ejemplos).
	- *Practica*:  Ejercicios que ponen en práctica lo aprendido. Se dividen en `funcional` e `imperativo`. En `funcional` están ejemplos codificados bajo el paradigma de programación funcional, y bajo `imperativo`, pues ejemplos codificados como estáis acostumbrados a programar.
	- *real* : [Ejemplos simulando a problemas reales](https://github.com/jssdocente/AAD/blob/main/Tema1/Tema1_Files/src/tema1/_ejemplos/real/). Ponen todo en práctica y permiten poner más piezas en juego.
		- **Servicio Meteorológico**:  Un ejemplo de un servicio meteorológico, obteniendo datos desde ficheros.


- **Recursos**:  [Cada apartado tiene sus propios recursos para utilizarlos](https://github.com/jssdocente/AAD/blob/main/Tema1/Tema1_Files/res/_ejemplos). En esta carpeta contiene todos los recursos que se necesitan para trabajar con cada uno de los apartados.
	 - El trabajo con recursos se fundamental, y cómo y donde almacenarlos para que se fácil su consumo es una tarea no fácil. En los ejemplos se incluye la forma de poder acceder a estos recursos, desde cualquier nivel o paquete.
	 
	 

#### FICHEROS XML

Por la limitación de tiempo, en este primer tema no vamos a ver como trabajar con ficheros XML.
En el pdf`UD1-Ficheros-Completa.pdf`se incluye documentación sobre los ficheros XML. Revisarla.

En siguientes temas, veremos cómo convertir Entidades (Objetos) a ficheros XML y a la inversa.

Lo que se denomina, **Serializar**, transformar una Entidad (objeto) a un texto. Ese texto bien puede ser un formato JSON o XML, aunqute también se puede transformar a otros formatos, pero los más utilizado son estos.   