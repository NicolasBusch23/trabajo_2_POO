import java.util.Scanner;

public class Planeta {
    // Atributos base definidos inicialmente
    String nombre = null;
    int cantidadSatélites = 0;
    double masa = 0;
    double volumen = 0;
    int diámetro = 0;
    int distanciaSol = 0;

    // --- NUEVOS ATRIBUTOS AGREGADOS ---
    double periodoOrbital; // Tiempo en completar una vuelta al Sol (en años)
    double periodoRotación; // Tiempo en girar sobre su propio eje (en días)

    // Definición del tipo enumerado
    enum tipoPlaneta {GASEOSO, TERRESTRE, ENANO}
    tipoPlaneta tipo;

    boolean esObservable = false;

    // Constructor actualizado para inicializar los atributos antiguos y los nuevos
    Planeta(String nombre, int cantidadSatélites, double masa, double volumen, 
            int diámetro, int distanciaSol, tipoPlaneta tipo, boolean esObservable,
            double periodoOrbital, double periodoRotación) {
        this.nombre = nombre;
        this.cantidadSatélites = cantidadSatélites;
        this.masa = masa;
        this.volumen = volumen;
        this.diámetro = diámetro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.esObservable = esObservable;
        // Inicialización de los nuevos parámetros
        this.periodoOrbital = periodoOrbital;
        this.periodoRotación = periodoRotación;
    }

    // Método imprimir modificado para incluir los periodos de tiempo
    void imprimir() {
        System.out.println("Nombre del planeta = " + nombre);
        System.out.println("Cantidad de satélites = " + cantidadSatélites);
        System.out.println("Masa del planeta = " + masa + " kg");
        System.out.println("Volumen del planeta = " + volumen + " km3");
        System.out.println("Diámetro del planeta = " + diámetro + " km");
        System.out.println("Distancia al sol = " + distanciaSol + " km");
        System.out.println("Tipo de planeta = " + tipo);
        System.out.println("Es observable = " + esObservable);
        // Salida de los nuevos datos
        System.out.println("Periodo orbital = " + periodoOrbital + " años");
        System.out.println("Periodo de rotación = " + periodoRotación + " días");
    }

    double calcularDensidad() {
        return masa / volumen;
    }

    boolean esPlanetaExterior() {
        float límite = (float) (149597870 * 3.4);
        return distanciaSol > límite;
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);

        // Registro de los dos planetas con la captura de datos completa
        for (int i = 1; i <= 2; i++) {
            System.out.println("--- INGRESO DE DATOS: PLANETA " + i + " ---");
            System.out.print("Nombre: "); String nom = lector.nextLine();
            System.out.print("Satélites: "); int sat = lector.nextInt();
            System.out.print("Masa (kg): "); double m = lector.nextDouble();
            System.out.print("Volumen (km3): "); double v = lector.nextDouble();
            System.out.print("Diámetro (km): "); int d = lector.nextInt();
            System.out.print("Distancia al Sol (km): "); int dist = lector.nextInt();
            
            // Captura de los nuevos atributos
            System.out.print("Periodo orbital (años): "); double pOrb = lector.nextDouble();
            System.out.print("Periodo de rotación (días): "); double pRot = lector.nextDouble();

            System.out.println("Tipo (1: GASEOSO, 2: TERRESTRE, 3: ENANO): ");
            int opc = lector.nextInt();
            tipoPlaneta t = tipoPlaneta.TERRESTRE;
            if (opc == 1) t = tipoPlaneta.GASEOSO;
            else if (opc == 3) t = tipoPlaneta.ENANO;

            System.out.print("¿Es observable? (true/false): ");
            boolean obs = lector.nextBoolean();
            lector.nextLine(); // Limpieza necesaria del buffer

            // Creación del objeto enviando los 10 parámetros requeridos
            Planeta p = new Planeta(nom, sat, m, v, d, dist, t, obs, pOrb, pRot);

            System.out.println("\n--- FICHA TÉCNICA REGISTRADA ---");
            p.imprimir();
            System.out.println("Densidad = " + p.calcularDensidad() + " kg/km3");
            System.out.println("¿Es planeta exterior? = " + p.esPlanetaExterior());
            System.out.println("------------------------------------------\n");
        }
        lector.close();
    }
}