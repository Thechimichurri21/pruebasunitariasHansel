    import static org.junit.jupiter.api.Assertions.*;

    /**
     * @author Hansel Altamirano
     */
    class AlmacenTest {

        @org.junit.jupiter.api.Test
        void recibirMercancia() {
            Almacen almacen = new Almacen(500);
            almacen.recibirMercancia(40);
            assertEquals(540,almacen.getStockActual());
            assertEquals(1,almacen.getTotalEntradas());

            almacen = new Almacen(500);
            almacen.recibirMercancia(501);
            assertEquals(500, almacen.getStockActual());
            assertEquals(0,almacen.getTotalEntradas());

        }

        @org.junit.jupiter.api.Test
        void enviarMercancia() {
            //true
            Almacen a = new Almacen(200);
            // Caso 1: Sacar cantidad válida
            assertTrue(a.enviarMercancia(50));
            assertEquals(150, a.getStockActual());
            assertEquals(50, a.getTotalSalidas());

            // Caso 2: Sacar más de lo que hay
            assertFalse(a.enviarMercancia(200));

        }

        @org.junit.jupiter.api.Test
        void transferirProductos() {
            //Crear dos objetos
            Almacen origen = new Almacen(500);
            Almacen destino = new Almacen(100);

            // Transferencia válida
            assertTrue(origen.transferirProductos(200, destino));
            assertEquals(300, origen.getStockActual());
            assertEquals(300, destino.getStockActual());

            // Transferencia inválida (no hay suficiente en origen)
            assertFalse(origen.transferirProductos(400, destino));
        }

        @org.junit.jupiter.api.Test
        void calcularPorcentajeOcupacion() {
            Almacen a = new Almacen(500); // Mitad de 1000
            assertEquals(50.0, a.calcularPorcentajeOcupacion());

            a.recibirMercancia(250); // 750 de 1000
            assertEquals(75.0, a.calcularPorcentajeOcupacion());
        }

        @org.junit.jupiter.api.Test
        void reiniciarEstadisticas() {
            Almacen a = new Almacen(100);
            a.recibirMercancia(50);
            a.enviarMercancia(20);

            a.reiniciarEstadisticas();

            assertEquals(0, a.getTotalEntradas());
            assertEquals(0, a.getTotalSalidas());
            assertEquals(130, a.getStockActual());
        }
    }