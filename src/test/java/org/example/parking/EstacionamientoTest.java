package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("QWE123", "Fiat Cronos", Vehiculo.Tipo.AUTO);
        String dni = "46130274";
        String nombre = "Jazmin";


        estacionamiento.ingresarVehiculo(dni, nombre, vehiculo);


        Ticket ticket = estacionamiento.retirarVehiculo("QWE123");


        assertEquals("QWE123", ticket.getVehiculo().getPatente());
        assertNotNull(ticket.getHoraSalida());
        long minutos = ticket.calcularMinutos();
        assertTrue(minutos >= 0 && minutos <= 200, "Los minutos deben estar entre 0 y 200");
    }

    @Test
    public void testCalcularPrecio() throws Exception {

        // TODO test
        Cliente cliente = new Cliente("78965412", "Julian Marcos");

        Vehiculo auto = new Vehiculo("ASD345", "Peugot 208", Vehiculo.Tipo.AUTO);
        Ticket ticketAuto = new Ticket(cliente, auto);
        ticketAuto.marcarSalida();
        double precioAuto = ticketAuto.calcularPrecio();
        assertTrue(precioAuto >= 100, "El precio para AUTO debe ser al menos 100");

        Vehiculo suv = new Vehiculo("SUV456", "Toyota", Vehiculo.Tipo.SUV);
        Ticket ticketSuv = new Ticket(cliente, suv);
        ticketSuv.marcarSalida();
        double precioSuv = ticketSuv.calcularPrecio();
        assertTrue(precioSuv >= 130, "El precio para SUV debe ser al menos 130");

        Vehiculo pickup = new Vehiculo("PKP789", "Ford Ranger", Vehiculo.Tipo.PICKUP);
        Ticket ticketPickup = new Ticket(cliente, pickup);
        ticketPickup.marcarSalida();
        double precioPickup = ticketPickup.calcularPrecio();
        assertTrue(precioPickup >= 180, "El precio para PICKUP debe ser al menos 180");


    }

}