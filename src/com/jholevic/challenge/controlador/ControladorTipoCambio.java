package com.jholevic.challenge.controlador;

import com.jholevic.challenge.modelos.RespuestaTipoCambio;
import com.jholevic.challenge.servicio.ServicioTipoCambio;

import java.io.IOException;

public class ControladorTipoCambio {
    private final ServicioTipoCambio servicio;

    public ControladorTipoCambio(ServicioTipoCambio servicio) {
        this.servicio = servicio;
    }

    public Double convertirMoneda(String monedaOrigen, String monedaDestino, Double monto) {
        try {
            // Validaciones básicas
            if (monedaOrigen == null || monedaDestino == null || monto == null) {
                throw new IllegalArgumentException("Todos los parámetros son requeridos");
            }

            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser positivo");
            }

            // Obtener tasas de cambio
            RespuestaTipoCambio datos = servicio.obtenerTasa(monedaOrigen);

            // Verificar respuesta exitosa
            if (!datos.getResult().equals("success")) {
                throw new RuntimeException("La API no devolvió un resultado exitoso");
            }

            // Verificar moneda destino
            if (!datos.getConversionRates().containsKey(monedaDestino.toUpperCase())) {
                throw new IllegalArgumentException("Moneda destino no soportada: " + monedaDestino);
            }

            Double tasaDestino = datos.getConversionRates().get(monedaDestino.toUpperCase());
            return monto * tasaDestino;

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            return null;
        }
    }
}