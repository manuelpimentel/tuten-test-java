# tuten-test-java

Para compilar el proyecto colocarse en el mismo y ejecutar el comando 'mvn clean install' desde el terminal

Si se quiere dejar corriendo en local se debe ejecutar el comando 'mvn spring-boot:run', el mismo servirá desde el puerto 8080

El endpoint para el servicio solicitado es '/time' es un POST que debe tener en el body los atributos de la siguiente forma:
{
	"hour": "00:00:00",
	"timeZone": "-4"
}
