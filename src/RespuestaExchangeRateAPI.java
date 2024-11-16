import java.util.Map;

public class RespuestaExchangeRateAPI {
    private String base_code;
    private Map<String, Double> conversion_rates;  // Cambiado de 'rates' a 'conversion_rates'

    // Getters y setters
    public String getBaseCode() {
        return base_code;
    }

    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversionRates() {  // Cambiado de 'getRates' a 'getConversionRates'
        return conversion_rates;
    }

    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
