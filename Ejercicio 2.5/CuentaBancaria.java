import java.util.Scanner;

public class CuentaBancaria {
    // Atributos base
    String nombresTitular;
    String apellidosTitular;
    int númeroCuenta;
    
    // Tipo de cuenta como enumerado
    enum tipo {AHORROS, CORRIENTE}
    tipo tipoCuenta;
    
    float saldo = 0;

    // --- NUEVO ATRIBUTO (Ejercicio propuesto) ---
    float porcentajeInterésMensual;

    /**
     * Constructor que inicializa los atributos. 
     * El saldo no se pasa porque inicia en cero.
     */
    CuentaBancaria(String nombresTitular, String apellidosTitular, int númeroCuenta, 
                   tipo tipoCuenta, float porcentajeInterésMensual) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.númeroCuenta = númeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.porcentajeInterésMensual = porcentajeInterésMensual;
    }

    void imprimir() {
        System.out.println("\n--- DATOS DE LA CUENTA ---");
        System.out.println("Titular: " + nombresTitular + " " + apellidosTitular);
        System.out.println("Número de Cuenta: " + númeroCuenta);
        System.out.println("Tipo de Cuenta: " + tipoCuenta);
        System.out.println("Saldo Actual: $" + saldo);
        System.out.println("Tasa de Interés Mensual: " + porcentajeInterésMensual + "%");
    }

    void consultarSaldo() {
        System.out.println("El saldo actual es: $" + saldo);
    }

    boolean consignar(int valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Consignación exitosa de $" + valor);
            return true;
        } else {
            System.out.println("El valor a consignar debe ser mayor que cero.");
            return false;
        }
    }

    boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retiro exitoso de $" + valor);
            return true;
        } else {
            System.out.println("Transacción fallida: Monto inválido o saldo insuficiente.");
            return false;
        }
    }

    // --- NUEVO MÉTODO (Ejercicio propuesto) ---
    void aplicarInterés() {
        float interés = saldo * (porcentajeInterésMensual / 100);
        saldo += interés;
        System.out.println("Se ha aplicado un interés del " + porcentajeInterésMensual + "%.");
        System.out.println("Monto abonado por interés: $" + interés);
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);

        System.out.println("=== APERTURA DE CUENTA BANCARIA ===");
        System.out.print("Nombres del titular: "); String nom = lector.nextLine();
        System.out.print("Apellidos del titular: "); String ape = lector.nextLine();
        System.out.print("Número de cuenta: "); int num = lector.nextInt();
        
        System.out.println("Seleccione Tipo (1: Ahorros, 2: Corriente): ");
        int opc = lector.nextInt();
        tipo t = (opc == 2) ? tipo.CORRIENTE : tipo.AHORROS;

        System.out.print("Ingrese el porcentaje de interés mensual [%]: ");
        float intMes = lector.nextFloat();

        // Crear la cuenta
        CuentaBancaria cuenta = new CuentaBancaria(nom, ape, num, t, intMes);
        cuenta.imprimir();

        // Pruebas de transacciones
        System.out.print("\nIngrese valor a consignar [$]: ");
        cuenta.consignar(lector.nextInt());

        System.out.print("Ingrese valor a retirar [$]: ");
        cuenta.retirar(lector.nextInt());

        // Aplicar interés propuesto
        cuenta.aplicarInterés();
        
        cuenta.imprimir();

        lector.close();
    }
}