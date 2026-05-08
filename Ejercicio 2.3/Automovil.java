import java.util.Scanner;

public class Automovil {
    // Atributos de la clase
    String marca;
    int modelo;
    int motor;
    int númeroPuertas;
    int cantidadAsientos;
    int velocidadMáxima;
    int velocidadActual = 0;
    
    // Atributos de los ejercicios propuestos
    boolean esAutomático; 
    int cantidadMultas = 0;
    double valorTotalMultas = 0;
    final double VALOR_MULTA = 150000.0; // Valor de cada infracción

    // Enumeraciones
    enum tipoCom {GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL}
    tipoCom tipoCombustible;

    enum tipoA {CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV}
    tipoA tipoAutomóvil;

    enum tipoColor {BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA}
    tipoColor color;

    // Constructor completo
    Automovil(String marca, int modelo, int motor, tipoCom tipoCombustible, 
              tipoA tipoAutomóvil, int númeroPuertas, int cantidadAsientos, 
              int velocidadMáxima, tipoColor color, boolean esAutomático) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomóvil = tipoAutomóvil;
        this.númeroPuertas = númeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMáxima = velocidadMáxima;
        this.color = color;
        this.esAutomático = esAutomático;
    }

    // Métodos Get y Set para el nuevo atributo
    boolean getEsAutomático() { return esAutomático; }
    void setEsAutomático(boolean esAutomático) { this.esAutomático = esAutomático; }

    // Lógica de aceleración con control de multas
    void acelerar(int incremento) {
        if (velocidadActual + incremento <= velocidadMáxima) {
            velocidadActual += incremento;
            System.out.println("Acelerando... Velocidad actual: " + velocidadActual + " [km/h]");
        } else {
            System.out.println("¡ALERTA! Intento de superar el límite de " + velocidadMáxima + " [km/h]");
            cantidadMultas++;
            valorTotalMultas += VALOR_MULTA;
            System.out.println("Multa generada. Infracciones totales: " + cantidadMultas);
        }
    }

    void desacelerar(int decremento) {
        if (velocidadActual - decremento >= 0) {
            velocidadActual -= decremento;
            System.out.println("Desacelerando... Velocidad actual: " + velocidadActual + " [km/h]");
        } else {
            System.out.println("Error: La velocidad no puede ser inferior a 0 [km/h]");
        }
    }

    void frenar() {
        velocidadActual = 0;
        System.out.println("Frenado total aplicado. Velocidad: 0 [km/h]");
    }

    double calcularTiempoLlegada(int distancia) {
        if (velocidadActual == 0) return 0;
        return (double) distancia / velocidadActual;
    }

    void imprimir() {
        System.out.println("\n--- FICHA TÉCNICA DEL AUTOMÓVIL ---");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo [año]: " + modelo);
        System.out.println("Cilindraje [litros]: " + motor);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Categoría: " + tipoAutomóvil);
        System.out.println("Transmisión: " + (esAutomático ? "Automática" : "Manual"));
        System.out.println("Velocidad Máxima [km/h]: " + velocidadMáxima);
        System.out.println("Color: " + color);
        System.out.println("Multas acumuladas: " + cantidadMultas + " (Valor total: $" + valorTotalMultas + ")");
        System.out.println("------------------------------------");
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);

        System.out.println("=== SISTEMA DE REGISTRO VEHICULAR ===");
        System.out.print("Marca del fabricante: "); String mar = lector.nextLine();
        System.out.print("Modelo [año de fabricación]: "); int mod = lector.nextInt();
        System.out.print("Motor [volumen en litros]: "); int mot = lector.nextInt();
        
        System.out.println("Seleccione combustible (1:Gasolina, 2:Diésel, 3:Gas Natural): ");
        int opcC = lector.nextInt();
        tipoCom tc = (opcC == 2) ? tipoCom.DIESEL : (opcC == 3 ? tipoCom.GAS_NATURAL : tipoCom.GASOLINA);

        System.out.println("Seleccione tipo (1:Ciudad, 2:SUV, 3:Ejecutivo): ");
        int opcA = lector.nextInt();
        tipoA ta = (opcA == 2) ? tipoA.SUV : (opcA == 3 ? tipoA.EJECUTIVO : tipoA.CIUDAD);

        System.out.print("Número de puertas [cantidad]: "); int pue = lector.nextInt();
        System.out.print("Número de asientos [cantidad]: "); int asi = lector.nextInt();
        System.out.print("Velocidad máxima permitida [km/h]: "); int vmax = lector.nextInt();

        System.out.println("Seleccione color (1:Blanco, 2:Negro, 3:Rojo): ");
        int opcCol = lector.nextInt();
        tipoColor col = (opcCol == 2) ? tipoColor.NEGRO : (opcCol == 3 ? tipoColor.ROJO : tipoColor.BLANCO);

        System.out.print("¿La transmisión es automática? [true/false]: "); boolean aut = lector.nextBoolean();

        // Inicialización del objeto
        Automovil miAuto = new Automovil(mar, mod, mot, tc, ta, pue, asi, vmax, col, aut);
        miAuto.imprimir();

        // Ciclo de pruebas lógicas
        System.out.println("\n--- INICIANDO PRUEBAS DE CONDUCCIÓN ---");
        System.out.print("¿A cuánto desea acelerar inicialmente? [km/h]: ");
        int inc = lector.nextInt();
        miAuto.acelerar(inc);

        System.out.print("Ingrese distancia del viaje [km] para estimar tiempo: ");
        int d = lector.nextInt();
        System.out.println("Tiempo estimado de llegada: " + miAuto.calcularTiempoLlegada(d) + " [horas]");

        System.out.print("\n¿Cuánto desea desacelerar? [km/h]: ");
        int dec = lector.nextInt();
        miAuto.desacelerar(dec);

        miAuto.frenar();
        miAuto.imprimir();

        lector.close();
    }
}