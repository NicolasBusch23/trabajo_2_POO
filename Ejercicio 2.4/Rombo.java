public class Rombo {
    double diagonalMayor;
    double diagonalMenor;
    double lado;

    public Rombo(double dMayor, double dMenor, double lado) {
        this.diagonalMayor = dMayor;
        this.diagonalMenor = dMenor;
        this.lado = lado;
    }

    double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    double calcularPerímetro() {
        return 4 * lado;
    }
}