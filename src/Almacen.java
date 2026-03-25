// ---- PROGRAMAR EL RESTO DE LOS MÉTODOS ----

/**
 * @author Hansel Altamirano
 */
public class Almacen {
    
    // -------------------------------------
    // Atributos de Clase 
    // -------------------------------------
    
    private int stockActual;           // Productos disponibles actualmente
    private int totalEntradas;          // Total de productos que han entrado
    private int totalSalidas;           // Total de productos que han salido
    private static final int CAPACIDAD_MAXIMA = 1000; // Capacidad máxima del almacén
    
    // -------------------------------------
    //   METODOS:
    // -------------------------------------
    
    
    public static int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }
    
    // --METODOS DE INSTANCIA (OBJETOS) ----------------------------  
    
    // Constructores
    public Almacen(int stockInicial) {
        if (stockInicial >= 0 && stockInicial <= CAPACIDAD_MAXIMA) {
            this.stockActual = stockInicial;
        } else {
            this.stockActual = 0; // Valor por defecto si el stock inicial no es válido
        }
        this.totalEntradas = 0;
        this.totalSalidas = 0;
    }
    
    public Almacen() {
        this(0); // Llamo al primer constructor con stock inicial 0
    }
    
    // Getters
    public int getStockActual() {
        return stockActual;
    }
    
    public int getTotalEntradas() {
        return totalEntradas;
    }
    
    public int getTotalSalidas() {
        return totalSalidas;
    }
    
    // Resto de los MÉTODOS
    
    /**
     * Añade productos al almacén
     * @param cantidad Número de productos a añadir (debe ser positivo)
     * @return true si se pudo realizar la operación, false en caso contrario
     */
    public boolean recibirMercancia(int cantidad) {
        // TODO: Implementar //hecho
        // Debe verificar que cantidad sea positiva
        if(cantidad>0 && this.stockActual+cantidad<=CAPACIDAD_MAXIMA){
            this.stockActual+=cantidad;
            this.totalEntradas++;
            return true;
        }else {
            return false;
        }
        // Debe verificar que no se supere la CAPACIDAD_MAXIMA
        // Si es posible, incrementa stockActual y totalEntradas
        // Devuelve true si se realizó la operación


    }
    
    /**
     * Retira productos del almacén
     * @param cantidad Número de productos a retirar (debe ser positivo)
     * @return true si se pudo realizar la operación, false en caso contrario
     */
    public boolean enviarMercancia(int cantidad) {
        // TODO: Implementar
        // Debe verificar que cantidad sea positiva
        if(cantidad>0 && this.stockActual >= cantidad){
            this.stockActual-= cantidad ; //Restamos la cantidad pedida
            this.totalSalidas+= cantidad; // Sumamos los productos que salen
            return true;
        } else {
            return false;
        }



        // Debe verificar que haya stock suficiente
        
        // Si es posible, decrementa stockActual e incrementa totalSalidas
        // Devuelve true si se realizó la operación

    }
    
    /**
     * Transfiere productos de este almacén a otro
     * @param cantidad Cantidad a transferir
     * @param destino Almacén destino
     * @return true si se pudo realizar la transferencia
     */
    public boolean transferirProductos(int cantidad, Almacen destino) {
        // TODO: Implementar
        // Verificar que cantidad sea positiva
        // Verificar que haya stock suficiente en origen
        // Verificar que el destino tenga capacidad suficiente
        // Si todo es correcto, retirar del origen y añadir al destino
        // Debe actualizar las estadísticas de ambos almacenes
        if(cantidad > 0 && this.stockActual >= cantidad) {
            if (destino.getStockActual() + cantidad <= CAPACIDAD_MAXIMA) {
                this.enviarMercancia(cantidad);
                destino.recibirMercancia(cantidad);
                return true;
            }
        }

        return false;
    }
    
    /**
     * Calcula el porcentaje de ocupación del almacén
     * @return porcentaje de ocupación (0-100)
     */
    public double calcularPorcentajeOcupacion() {
        // TODO: Implementar
        // Calcular el porcentaje de ocupación basado en CAPACIDAD_MAXIMA
        return(this.stockActual * 100.0) / CAPACIDAD_MAXIMA;
    }
    
    /**
     * Reinicia las estadísticas del almacén (entradas y salidas)
     * pero mantiene el stock actual
     */
    public void reiniciarEstadisticas() {
        // TODO: Implementar
        // Poner totalEntradas y totalSalidas a 0
        // Mantener el stockActual sin cambios
        this.totalSalidas=0;
        this.totalEntradas=0;
    }
    
    /**
     * Consultar el estado del almacén
     * @return String con la información del almacén
     */
    public String consultarEstado() {
        return "Stock actual: " + stockActual + 
               " | Entradas totales: " + totalEntradas + 
               " | Salidas totales: " + totalSalidas +
               " | Ocupación: " + String.format("%.1f", calcularPorcentajeOcupacion()) + "%";
    }
}
