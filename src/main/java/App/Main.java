package App;

import DAO.EmpresaDAO;
import Entities.Consumidor;
import Entities.Empresa;
import Entities.Feedback;
import Entities.Orden;
import Entities.Repartidor;
import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Cliente nuevo
        Consumidor cliente = Consumidor.builder()
                .nombre("Rodri")
                .apellido("Fernández")
                .telefono("1167894321")
                .email("rodri@buen-sabor.com")
                .fechaNacimiento(LocalDate.of(2000, 6, 10))
                .build();

        // Pedido del cliente
        Orden pedido = Orden.builder()
                .cliente(cliente)
                .fechaPedido(LocalDate.now())
                .horaEstimadaFinalizacion(LocalTime.of(21, 0))
                .estado(Estado.PREPARACION)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.EFECTIVO)
                .total(4200.50)
                .totalCosto(3100.00)
                .build();

        // Repartidor que lleva el pedido
        Repartidor repartidor = new Repartidor(
                1L,
                "Juancito",
                "Zanella 110"
        );

        // Feedback del cliente
        Feedback feedback = new Feedback(
                1L,
                "¡Excelente atención! El pedido llegó rápido y caliente.",
                5
        );

        // Impresión final
        System.out.println("=== Buen Sabor - Sistema de Pedidos ===");
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Pedido para el día: " + pedido.getFechaPedido());
        System.out.println("Forma de pago: " + pedido.getFormaPago());
        System.out.println("Tipo de envío: " + pedido.getTipoEnvio());
        System.out.println("Estado actual: " + pedido.getEstado());
        System.out.println("Entregado por: " + repartidor.getNombre() + " en una " + repartidor.getTipoVehiculo());
        System.out.println("Comentario del cliente: \"" + feedback.getComentario() + "\"");
        System.out.println("Puntuación: " + feedback.getPuntuacion() + "/5 ⭐");

        // =============================
        // === PRUEBA DE EmpresaDAO ===
        // =============================
        Empresa empresa1 = new Empresa("Buen Sabor", "Buen Sabor S.A.", 203456789);
        Empresa empresa2 = new Empresa("Rico Sabor", "Rico Sabor S.A.", 209876543);

        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.guardar(empresa1);
        empresaDAO.guardar(empresa2);

        System.out.println("\n=== Empresas registradas ===");
        empresaDAO.obtenerTodas().forEach(e -> System.out.println("- " + e.getNombre()));

        System.out.println("Buscando empresa con CUIL 203456789:");
        empresaDAO.buscarPorCuil(203456789).ifPresentOrElse(
                e -> System.out.println("→ Encontrada: " + e.getNombre()),
                () -> System.out.println("→ No se encontró la empresa")
        );

        System.out.println("Eliminando empresa con CUIL 209876543:");
        boolean eliminada = empresaDAO.eliminarPorCuil(209876543);
        System.out.println("→ Eliminación exitosa: " + eliminada);
    }
}