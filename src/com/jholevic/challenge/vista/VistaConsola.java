package com.jholevic.challenge.vista;

import com.jholevic.challenge.controlador.ControladorTipoCambio;
import com.jholevic.challenge.servicio.ServicioTipoCambio;
import java.util.Scanner;

public class VistaConsola {
    private final Scanner scanner;
    private final ControladorTipoCambio controlador;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
        this.controlador = new ControladorTipoCambio(new ServicioTipoCambio());
    }

    public void iniciar() {
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("Ejemplos de monedas: USD, EUR, PEN, JPY, GBP, etc.");

        while (true) {
            try {
                System.out.print("\nIngrese la moneda de origen (ej: USD) o 'salir' para terminar: ");
                String monedaOrigen = scanner.nextLine().trim().toUpperCase();

                if (monedaOrigen.equals("SALIR")) break;

                System.out.print("Ingrese la moneda de destino (ej: PEN): ");
                String monedaDestino = scanner.nextLine().trim().toUpperCase();

                System.out.print("Ingrese el monto a convertir: ");
                double monto;
                try {
                    monto = Double.parseDouble(scanner.nextLine());
                    if (monto <= 0) {
                        System.out.println("Error: El monto debe ser positivo.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido.");
                    continue;
                }

                Double resultado = controlador.convertirMoneda(monedaOrigen, monedaDestino, monto);

                if (resultado != null) {
                    System.out.printf("\nResultado: %.2f %s = %.2f %s\n",
                            monto, monedaOrigen, resultado, monedaDestino);
                } else {
                    System.out.println("No se pudo realizar la conversión. Verifique las monedas ingresadas.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("\nPrograma finalizado.");
    }
}