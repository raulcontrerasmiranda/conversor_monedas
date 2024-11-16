public class Conversor {

    private final String API_KEY = "a97278ebde724fa34d87e7d5";  // Inserta tu clave API
    private final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double convert(String fromCurrency, String toCurrency, double amount) {
        try {
            // Llamar a la API para obtener las tasas de cambio
            ApiClient client = new ApiClient();
            RespuestaExchangeRateAPI response = client.getExchangeRates(API_URL + fromCurrency);

            // Verificar si las tasas de cambio están disponibles
            if (response.getConversionRates() == null) {
                throw new RuntimeException("Las tasas de cambio no están disponibles.");
            }

            // Verificar si la moneda de destino está en el mapa de conversion_rates
            if (!response.getConversionRates().containsKey(toCurrency.toUpperCase())) {
                throw new RuntimeException("No se encontró la tasa de cambio para " + toCurrency);
            }

            // Obtener la tasa de cambio y hacer la conversión
            double exchangeRate = response.getConversionRates().get(toCurrency.toUpperCase());
            return amount * exchangeRate;

        } catch (Exception e) {
            System.out.println("Error al convertir la moneda: " + e.getMessage());
            return 0;
        }
    }
}