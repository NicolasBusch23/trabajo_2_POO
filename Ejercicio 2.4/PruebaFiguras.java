import java.util.Scanner;

public class PruebaFiguras {
    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);

        System.out.println("--- DATOS DEL CÍRCULO ---");
        System.out.print("Ingrese el radio [cm]: ");
        Circulo figura1 = new Circulo(lector.nextInt());

        System.out.println("\n--- DATOS DEL RECTÁNGULO ---");
        System.out.print("Ingrese la base [cm]: "); int bRec = lector.nextInt();
        System.out.print("Ingrese la altura [cm]: "); int hRec = lector.nextInt();
        Rectangulo figura2 = new Rectangulo(bRec, hRec);

        System.out.println("\n--- DATOS DEL CUADRADO ---");
        System.out.print("Ingrese el lado [cm]: ");
        Cuadrado figura3 = new Cuadrado(lector.nextInt());

        System.out.println("\n--- DATOS DEL TRIÁNGULO RECTÁNGULO ---");
        System.out.print("Ingrese la base [cm]: "); int bTri = lector.nextInt();
        System.out.print("Ingrese la altura [cm]: "); int hTri = lector.nextInt();
        TrianguloRectangulo figura4 = new TrianguloRectangulo(bTri, hTri);

        System.out.println("\n--- DATOS DEL ROMBO ---");
        System.out.print("Diagonal Mayor [cm]: "); double dMay = lector.nextDouble();
        System.out.print("Diagonal Menor [cm]: "); double dMen = lector.nextDouble();
        System.out.print("Lado [cm]: "); double ladoR = lector.nextDouble();
        Rombo figura5 = new Rombo(dMay, dMen, ladoR);

        System.out.println("\n--- DATOS DEL TRAPECIO ---");
        System.out.print("Base Mayor [cm]: "); double bTMay = lector.nextDouble();
        System.out.print("Base Menor [cm]: "); double bTMen = lector.nextDouble();
        System.out.print("Altura [cm]: "); double hTrap = lector.nextDouble();
        System.out.print("Lado lateral 1 [cm]: "); double l1 = lector.nextDouble();
        System.out.print("Lado lateral 2 [cm]: "); double l2 = lector.nextDouble();
        Trapecio figura6 = new Trapecio(bTMay, bTMen, hTrap, l1, l2);

        // Resultados
        System.out.println("\n================ RESULTADOS ================");
        System.out.println("Círculo - Área: " + figura1.calcularArea() + ", Perímetro: " + figura1.calcularPerímetro());
        System.out.println("Rectángulo - Área: " + figura2.calcularArea() + ", Perímetro: " + figura2.calcularPerímetro());
        System.out.println("Cuadrado - Área: " + figura3.calcularArea() + ", Perímetro: " + figura3.calcularPerímetro());
        System.out.println("Triángulo - Área: " + figura4.calcularArea() + ", Perímetro: " + figura4.calcularPerímetro());
        figura4.determinarTipoTriángulo();
        System.out.println("Rombo - Área: " + figura5.calcularArea() + ", Perímetro: " + figura5.calcularPerímetro());
        System.out.println("Trapecio - Área: " + figura6.calcularArea() + ", Perímetro: " + figura6.calcularPerímetro());
        
        lector.close();
    }
}