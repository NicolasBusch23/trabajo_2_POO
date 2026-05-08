import java.util.Scanner;

public class Persona {
    // Atributos de la clase para almacenar la información de la persona
    String nombre;
    String apellidos;
    String númeroDocumentoIdentidad;
    int añoNacimiento;
    String paísNacimiento; 
    char género;

    // Constructor para inicializar todos los atributos al crear el objeto
    Persona(String nombre, String apellidos, String númeroDocumentoIdentidad, 
            int añoNacimiento, String paísNacimiento, char género) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.númeroDocumentoIdentidad = númeroDocumentoIdentidad;
        this.añoNacimiento = añoNacimiento;
        this.paísNacimiento = paísNacimiento;
        this.género = género;
    }

    // Método para imprimir los datos almacenados en el objeto
    void imprimir() {
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellidos = " + apellidos);
        System.out.println("Número de documento de identidad = " + númeroDocumentoIdentidad);
        System.out.println("Año de nacimiento = " + añoNacimiento);
        System.out.println("País de nacimiento = " + paísNacimiento);
        // Validación simple para mostrar el género completo
        System.out.println("Género = " + (género == 'H' ? "Hombre" : "Mujer"));
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        
        // Registro de los datos de la primera persona
        System.out.println("--- DATOS PERSONA 1 ---");
        System.out.print("Nombre: "); String nom1 = lector.nextLine();
        System.out.print("Apellidos: "); String ape1 = lector.nextLine();
        System.out.print("Documento: "); String doc1 = lector.nextLine();
        System.out.print("Año de nacimiento: "); 
        int año1 = lector.nextInt();
        lector.nextLine(); // Limpieza de buffer necesaria tras leer un entero
        System.out.print("País: "); String pais1 = lector.nextLine();
        System.out.print("Género (H/M): "); 
        char gen1 = lector.next().toUpperCase().charAt(0);
        lector.nextLine(); // Limpieza de buffer para la siguiente entrada

        // Instancia del primer objeto Persona
        Persona p1 = new Persona(nom1, ape1, doc1, año1, pais1, gen1);

        // Registro de los datos de la segunda persona
        System.out.println("\n--- DATOS PERSONA 2 ---");
        System.out.print("Nombre: "); String nom2 = lector.nextLine();
        System.out.print("Apellidos: "); String ape2 = lector.nextLine();
        System.out.print("Documento: "); String doc2 = lector.nextLine();
        System.out.print("Año de nacimiento: "); 
        int año2 = lector.nextInt();
        lector.nextLine(); 
        System.out.print("País: "); String pais2 = lector.nextLine();
        System.out.print("Género (H/M): "); 
        char gen2 = lector.next().toUpperCase().charAt(0);

        // Instancia del segundo objeto Persona
        Persona p2 = new Persona(nom2, ape2, doc2, año2, pais2, gen2);

        // Salida de resultados por consola
        System.out.println("\n===========================");
        System.out.println("LISTADO DE PERSONAS:");
        System.out.println("===========================");
        p1.imprimir();
        p2.imprimir();
        
        lector.close();
    }
}