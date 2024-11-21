# Conversor de Monedas

Este proyecto es un **Conversor de Monedas** desarrollado en **Java** que permite realizar conversiones de divisas en tiempo real utilizando datos obtenidos de la API de ExchangeRate-API. La aplicación se diseñó con un enfoque modular y extensible, dividiendo claramente las responsabilidades de cada componente.

## Funcionalidad Principal

El conversor permite realizar conversiones de moneda de manera eficiente y sencilla. El usuario puede:

1. Especificar la moneda de origen (por ejemplo, `USD`).
2. Especificar la moneda de destino (por ejemplo, `EUR`).
3. Introducir la cantidad que desea convertir.
4. Recibir el valor equivalente en la moneda de destino.

El programa también maneja errores comunes como:
- Falta de conexión a la API.
- Tasas de cambio no disponibles para una moneda específica.
- Manejo de excepciones internas del sistema.

---

## Diseño del Proyecto

El diseño modular del proyecto divide las responsabilidades en clases específicas, promoviendo un código limpio y mantenible.

### 1. `Main.java`
- **Rol:** Controlador principal de la aplicación.
- **Responsabilidad:**
  - Captura la entrada del usuario (moneda de origen, moneda de destino y cantidad).
  - Llama al `Conversor` para realizar la conversión.
  - Muestra los resultados al usuario.

---

### 2. `Conversor.java`
- **Rol:** Implementa la lógica de conversión de monedas.
- **Responsabilidad:**
  - Obtiene las tasas de cambio en tiempo real llamando a la API.
  - Realiza los cálculos necesarios para convertir las cantidades ingresadas.
  - Maneja errores relacionados con monedas no soportadas o datos faltantes.

- **Características:**
  - Utiliza la URL base de la API y una clave de acceso para interactuar con el servicio de ExchangeRate-API.
  - Maneja respuestas de la API de forma robusta y asegura que los datos sean válidos antes de procesarlos.

---

### 3. `RespuestaExchangeRateAPI.java`
- **Rol:** Modelo de datos para procesar las respuestas de la API.
- **Responsabilidad:**
  - Representa la estructura de datos de la respuesta JSON, que incluye la moneda base y las tasas de conversión.
  - Utiliza un mapa (`Map<String, Double>`) para almacenar las tasas de conversión, facilitando el acceso rápido a los datos.

---

### 4. `ApiClient.java`
- **Rol:** Cliente HTTP que interactúa con la API ExchangeRate-API.
- **Responsabilidad:**
  - Realiza solicitudes HTTP GET a la API.
  - Procesa las respuestas JSON y las convierte en objetos de tipo `RespuestaExchangeRateAPI` utilizando la librería **Gson**.
  - Maneja errores relacionados con la conexión y la respuesta HTTP.

- **Características:**
  - Configura las solicitudes HTTP para garantizar que la comunicación sea eficiente.
  - Lee las respuestas utilizando un `BufferedReader` y convierte el JSON en un modelo Java.

---

## Manejo de Errores

El proyecto incorpora mecanismos para garantizar la estabilidad del programa:
- **Errores de Conexión:** Informa al usuario si no es posible conectarse a la API.
- **Datos Incompletos:** Lanza excepciones si no se encuentran tasas de cambio para una moneda específica.
- **Monedas No Soportadas:** Valida que las monedas ingresadas sean compatibles con los datos obtenidos de la API.

---

## Extensibilidad

El diseño permite una fácil ampliación y mejora:
1. **Compatibilidad con Nuevas APIs:** 
   - Si es necesario cambiar o agregar soporte para otra API, solo será necesario implementar un nuevo cliente compatible.
   
2. **Soporte para Conversiones Avanzadas:**
   - Es posible extender el programa para manejar conversiones entre múltiples monedas en una sola ejecución.

3. **Integración con Interfaces Gráficas:**
   - La lógica del programa es independiente de la interfaz, lo que facilita la integración con una GUI o una aplicación web.

---

## Notas Técnicas

- El proyecto aplica principios básicos de **Programación Orientada a Objetos (POO)**, asegurando que cada clase tenga una responsabilidad clara.
- Utiliza la librería **Gson** para procesar respuestas JSON de forma eficiente.
- Implementa un enfoque de "Fail Fast" para errores críticos, informando al usuario de inmediato si algo falla.

---

Este proyecto es un ejemplo práctico de cómo integrar aplicaciones Java con APIs externas y cómo estructurar un programa modular con un enfoque claro en la separación de responsabilidades.
