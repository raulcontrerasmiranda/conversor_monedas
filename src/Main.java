import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario las monedas y la cantidad
        System.out.print("Introduce la moneda de origen (ej: USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Introduce la moneda de destino (ej: EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Introduce la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Realizar la conversión
        Conversor conversor = new Conversor();
        double convertedAmount = conversor.convert(fromCurrency, toCurrency, amount);

        // Mostrar el resultado
        System.out.println(amount + " " + fromCurrency + " equivale a " + convertedAmount + " " + toCurrency);
    }
}