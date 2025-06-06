
# 🚀 Challenge Conversor de Monedas

[![Java](https://img.shields.io/badge/Java-21+-blue.svg)](https://java.com)
[![GitHub](https://img.shields.io/github/license/Johlevic/ChallengeConversorMonedas)](https://github.com/Johlevic/ChallengeConversorMonedas/blob/main/LICENSE)

Aplicación Java para conversión de monedas utilizando la API de ExchangeRate-API.

## 🌟 Características

- Conversión en tiempo real entre más de 150 monedas
- Interfaz de línea de comandos (CLI) intuitiva
- Manejo robusto de errores y validaciones
- Arquitectura MVC bien estructurada
- Uso de la API v6 de ExchangeRate

## 📦 Requisitos

- Java JDK 17 o superior
- Conexión a internet (para acceder a la API)
- API Key de [ExchangeRate-API](https://www.exchangerate-api.com/) (incluida en el código)

## 🛠️ Estructura del Proyecto
ChallengeConversorMonedas/
├── src/
│ ├── main/
│ │ ├── java/com/jholevic/challenge/
│ │ │ ├── controlador/ControladorTipoCambio.java
│ │ │ ├── modelos/RespuestaTipoCambio.java
│ │ │ ├── principal/Principal.java
│ │ │ ├── servicio/ServicioTipoCambio.java
│ │ │ └── vista/VistaConsola.java
├── README.md


## 🚀 Cómo Ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Johlevic/ChallengeConversorMonedas.git
2. Navega al directorio del proyecto:
    ```bash
   cd ChallengeConversorMonedas
3. Compila y ejecuta:
    ```bash
   javac src/main/java/com/jholevic/challenge/principal/Principal.java
   java -cp src/main/java com.jholevic.challenge.principal.Principal

## 💻 Uso
1. Ejecuta el programa

2. Ingresa la moneda de origen (ej: USD)

3. Ingresa la moneda de destino (ej: EUR)

4. Ingresa el monto a convertir

5. ¡Obtén el resultado al instante!

## Ejemplo

=== Conversor de Monedas ===
Ejemplos de monedas: USD, EUR, PEN, JPY, GBP, etc.

Ingrese la moneda de origen (ej: USD) o 'salir' para terminar: USD
Ingrese la moneda de destino (ej: PEN): EUR
Ingrese el monto a convertir: 100

Resultado: 100.00 USD = 93.50 EUR

## 🛡️ Licencia
Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Por favor abre un issue o pull request para sugerencias o mejoras.

Hecho con ❤️ por Jhony Lezama | https://github.com/Johlevic