# Selenium

Ejemplo de test funcionales con Selenium para el portal del Banco Aquarella.

## Prerrequisitos para ejecutar este test

- Un host (DNS `selenium`) con lo siguiente instalado:
  - Servidor Selenium standalone 3.141.59
  - `geckodriver` 0.27.0 o superior instalado en `$PATH` global
  - Firefox 80 o superior

- La aplicación de ejemplo [portal del Banco Aquarella](https://github.com/orcilatam/aquarella) instalada en un host de QA (DNS `test`, puede ser un host distinto de `selenium` )

## Ambiente para test funcionales

Los tests de QA (funcionales) usualmente se ejecutan en un servidor distinto al servidor donde se hace CI/CD. Esto es porque los tests funcionales usualmente requieren preparar un entorno de cliente similar al que usarán los usuarios finales. Adicionalmente, la aplicación a probar generalmente está instalada en su propio servidor de QA, con un ambiente propicio para pruebas.

Debido a la naturaleza del QA funcional, esta generalmente tiene *su propio pipeline*. Esto es así porque el ciciclo de pruebas funcionales está desacoplado de los ciclos de desarrollo rápido del CI.

El ambiente simulado para este test es el siguiente:

- El host `selenium` contiene el servidor de Selenium y el navegador usado para las pruebas
- El host `test` contiene la aplicación de ejemplo [portal del Banco Aquarella](https://github.com/orcilatam/aquarella)

Por simplicidad `selenium ` es el mismo `test` en nuestro caso.

### Pasos para ejecutar el test

1. El servidor de Selenium ya está preinstalado. Ejecute el servidor *en su propio terminal* de la siguiente forma:

	```sh
	java -jar /opt/selenium/selenium-server.jar
	```

2. Levante la aplicación de ejemplo *en su propio terminal* de la siguiente forma:

	```sh
	cd ~/curso/aquarella
	java -jar target/portal-aquarella-*.war
	```

3. Cree un job en Jenkins del tipo *Multibranch pipeline* apuntando a este repositorio, se recomienda usar el nombre “QA”, con pipeline como código definido en *Jenkinsfile*.

4. Ejecute el pipeline creado en el paso 3.
