# Selenium

Ejemplo de test funcionales con Selenium para el portal del Banco Aquarella.

## Prerrequisitos para ejecutar este test

- Un host (DNS `selenium`) con lo siguiente instalado:
  - Servidor Selenium 3.141.59 activo
  - `geckodriver` instalado en `$PATH` global
  - Firefox 80 o superior

- La aplicación portal de Aquarella ejecutándose un host de QA (DNS `test`)

## Ejecución de test

Cree un job en Jenkins del tipo *Multibranch pipeline* apuntando a este repositorio, con pipeline como código definido en *Jenkinsfile*.
