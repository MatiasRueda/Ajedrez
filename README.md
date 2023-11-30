# Ajedrez
![Static Badge](https://img.shields.io/badge/Estado%20-%20Terminado%20-%20green)

## Introducción
Proyecto para la Facultad de Ingeniería Universidad de Buenos Aires. 
La idea principal es demostrar los distintos conocimientos en patrones de diseño y en el patron de arquitectura (MVC). 
Por ejemplo se utiliza el patrón de diseño Observer para ayudarme a notificar al usuario cual pieza es capturada y  Abstract Factory para poder fabricar las distintas fichas del juego.
En caso de no tener conocimientos sobre el juego acá un articulo sobre el mismo: [https://es.wikipedia.org/wiki/Ajedrez](https://es.wikipedia.org/wiki/Ajedrez)

## Personas Contribuyentes
Proyecto realizado únicamente por mi.

## Tecnologías utilizadas
  - Java
  - JavaFX
  - JUnit

## Instalación
Para poder utilizarlo (En visual studio code):
1. Es necesario tener instalado Java y Javafx.
2. Abra visual studio code e instale la extensión 'Extension Pack for Java'
3. Diríjase al extremo superior derecho y de click a Run Java.

## Estructura
```
Ajedrez
├─ .gitignore
├─ pom.xml
├─ README.md
└─ src
   ├─ main
   │  ├─ java
   │  │  ├─ ajedrez
   │  │  │  ├─ App.java
   │  │  │  ├─ controller
   │  │  │  │  ├─ Accion.java
   │  │  │  │  ├─ Configuracion.java
   │  │  │  │  ├─ ControlBotones.java
   │  │  │  │  ├─ ESCENA.java
   │  │  │  │  ├─ Escenas.java
   │  │  │  │  ├─ Fichas.java
   │  │  │  │  ├─ Ganador.java
   │  │  │  │  ├─ Intro.java
   │  │  │  │  ├─ Juego.java
   │  │  │  │  ├─ Menu.java
   │  │  │  │  ├─ Musica.java
   │  │  │  │  ├─ MUSICA_CONTROL.java
   │  │  │  │  ├─ MUSICA_FONDO.java
   │  │  │  │  ├─ Registro.java
   │  │  │  │  ├─ Registros.java
   │  │  │  │  ├─ SONIDO.java
   │  │  │  │  ├─ Tablero.java
   │  │  │  │  └─ Turno.java
   │  │  │  ├─ model
   │  │  │  │  ├─ Ajedrez.java
   │  │  │  │  ├─ COLOR.java
   │  │  │  │  ├─ ControladorJaque.java
   │  │  │  │  ├─ FabricaDeFichas.java
   │  │  │  │  ├─ FICHA.java
   │  │  │  │  ├─ JUGADOR.java
   │  │  │  │  ├─ publisher
   │  │  │  │  │  ├─ Casilla.java
   │  │  │  │  │  ├─ Ficha.java
   │  │  │  │  │  └─ Publisher.java
   │  │  │  │  ├─ sucriber
   │  │  │  │  │  ├─ RegistroFichas.java
   │  │  │  │  │  └─ Suscriber.java
   │  │  │  │  ├─ Tablero.java
   │  │  │  │  ├─ tipodemovimiento
   │  │  │  │  │  ├─ Movible.java
   │  │  │  │  │  ├─ MovimientoConRango.java
   │  │  │  │  │  ├─ MovimientoPeon.java
   │  │  │  │  │  └─ MovimientoSinRango.java
   │  │  │  │  ├─ tipoficha
   │  │  │  │  │  ├─ Afil.java
   │  │  │  │  │  ├─ Caballo.java
   │  │  │  │  │  ├─ Peon.java
   │  │  │  │  │  ├─ Reina.java
   │  │  │  │  │  ├─ Rey.java
   │  │  │  │  │  └─ Torre.java
   │  │  │  │  ├─ TurnoUsuario.java
   │  │  │  │  └─ Usuario.java
   │  │  │  └─ view
   │  │  │     ├─ BotonCapturado.java
   │  │  │     ├─ BotonTablero.java
   │  │  │     └─ Imagen.java
   │  │  └─ module-info.java
   │  └─ resources
   │     └─ ajedrez
   │        ├─ Escenarios
   │        │  ├─ configuracion.fxml
   │        │  ├─ creditos.fxml
   │        │  ├─ fichas.fxml
   │        │  ├─ ganador.fxml
   │        │  ├─ intro.fxml
   │        │  ├─ juego.fxml
   │        │  └─ menu.fxml
   │        ├─ Estilos
   │        │  ├─ configuracion.css
   │        │  ├─ fichas.css
   │        │  ├─ ganador.css
   │        │  ├─ juego.css
   │        │  └─ menu.css
   │        ├─ Imagenes
   │        │  ├─ afil_blanco.png
   │        │  ├─ afil_negro.png
   │        │  ├─ caballo_blanco.png
   │        │  ├─ caballo_negro.png
   │        │  ├─ peon_blanco.png
   │        │  ├─ peon_negro.png
   │        │  ├─ reina_blanco.png
   │        │  ├─ reina_negro.png
   │        │  ├─ rey_blanco.png
   │        │  ├─ rey_negro.png
   │        │  ├─ torre_blanco.png
   │        │  └─ torre_negro.png
   │        └─ Musica
   │           ├─ acertado.mp3
   │           ├─ error.mp3
   │           ├─ intro.mp3
   │           ├─ jaque.mp3
   │           └─ juego.mp3
   └─ test
      └─ java
         └─ ajedrez
            ├─ AfilTest.java
            ├─ CaballoTest.java
            ├─ JuegoTest.java
            ├─ PeonTest.java
            ├─ RegistroFichasTest.java
            ├─ ReinaTest.java
            ├─ ReyTest.java
            ├─ TableroTest.java
            └─ TorreTest.java

```