import java.util.Scanner;

public class CuentaBancaria {
    String nombresTitular;
    String apellidosTitular;
    int númeroCuenta;
    
    enum tipo {AHORROS, CORRIENTE}
    tipo tipoCuenta;
    
    float saldo = 0;
    float porcentajeInterésMensual;
    
    // --- NUEVO ATRIBUTO (Ejercicio propuesto 2.6) ---
    boolean activa; 

    CuentaBancaria(String nombresTitular, String apellidosTitular, int númeroCuenta, 
                   tipo tipoCuenta, float porcentajeInterésMensual) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.númeroCuenta = númeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.porcentajeInterésMensual = porcentajeInterésMensual;
        // La cuenta inicia inactiva porque el saldo es 0
        this.activa = false; 
    }

    // Método para actualizar el estado de la cuenta
    private void validarEstado() {
        if (saldo > 0) {
            activa = true;
        } else {
            activa = false;
        }
    }

    void imprimir() {
        System.out.println("\n--- ESTADO DE CUENTA ---");
        System.out.println("Titular: " + nombresTitular + " " + apellidosTitular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Estado: " + (activa ? "ACTIVA" : "INACTIVA"));
    }

    // Modificado: Solo consigna si la cuenta está activa o si el monto la activará
    boolean consignar(int valor) {
        if (valor > 0) {
            saldo += valor;
            validarEstado();
            System.out.println("Consignación exitosa. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Error: El valor debe ser mayor a cero.");
            return false;
        }
    }

    // Modificado: Si el saldo llega a cero, se inactiva
    boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            validarEstado();
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Retiro fallido: Saldo insuficiente o monto inválido.");
            return false;
        }
    }

    // --- NUEVOS MÉTODOS EJERCICIO 2.6 ---

    /**
     * Compara el saldo de la cuenta actual con otra cuenta pasada por parámetro
     */
    void compararCuentas(CuentaBancaria otraCuenta) {
        if (this.saldo >= otraCuenta.saldo) {
            System.out.println("La cuenta de " + this.nombresTitular + " tiene un saldo mayor o igual.");
        } else {
            System.out.println("La cuenta de " + this.nombresTitular + " tiene un saldo menor.");
        }
    }

    /**
     * Transfiere dinero de ESTA cuenta a OTRA cuenta
     */
    void transferencia(CuentaBancaria cuentaDestino, int valor) {
        System.out.println("\nIniciando transferencia de $" + valor + "...");
        // Reutilizamos el método retirar para validar fondos
        if (this.retirar(valor)) { 
            cuentaDestino.consignar(valor);
            System.out.println("Transferencia completada con éxito.");
        } else {
            System.out.println("No se pudo realizar la transferencia.");
        }
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);

        // Creación de dos cuentas para probar la interacción
        System.out.println("CREACIÓN DE CUENTA 1");
        CuentaBancaria c1 = new CuentaBancaria("Pedro", "Pérez", 101, tipo.AHORROS, 1.5f);
        
        System.out.println("CREACIÓN DE CUENTA 2");
        CuentaBancaria c2 = new CuentaBancaria("Pablo", "Pinzón", 102, tipo.AHORROS, 1.5f);

        // Operaciones iniciales
        System.out.print("\n¿Cuánto desea consignar en la Cuenta 1? [$]: ");
        c1.consignar(lector.nextInt());
        
        System.out.print("¿Cuánto desea consignar en la Cuenta 2? [$]: ");
        c2.consignar(lector.nextInt());

        // Comparación
        c1.compararCuentas(c2);

        // Transferencia
        System.out.print("\nIngrese valor a transferir de Cuenta 1 a Cuenta 2 [$]: ");
        int montoTransf = lector.nextInt();
        c1.transferencia(c2, montoTransf);

        // Verificación final
        c1.imprimir();
        c2.imprimir();

        lector.close();
    }
}