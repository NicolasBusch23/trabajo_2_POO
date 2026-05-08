public class Trapecio {
    double baseMayor;
    double baseMenor;
    double altura;
    double lado1;
    double lado2;

    public Trapecio(double bMayor, double bMenor, double altura, double lado1, double lado2) {
        this.baseMayor = bMayor;
        this.baseMenor = bMenor;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    double calcularArea() {
        return ((baseMayor + baseMenor) * altura) / 2;
    }

    double calcularPerímetro() {
        return baseMayor + baseMenor + lado1 + lado2;
    }
}