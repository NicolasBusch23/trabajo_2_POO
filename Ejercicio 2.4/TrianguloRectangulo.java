public class TrianguloRectangulo {
    int base;
    int altura;

    public TrianguloRectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return (base * altura / 2.0);
    }

    double calcularHipotenusa() {
        return Math.pow(base * base + altura * altura, 0.5);
    }

    double calcularPerímetro() {
        return (base + altura + calcularHipotenusa());
    }

    void determinarTipoTriángulo() {
        double hipotenusa = calcularHipotenusa();
        if ((base == altura) && (base == hipotenusa)) {
            System.out.println("Es un triángulo equilátero");
        } else if ((base != altura) && (base != hipotenusa) && (altura != hipotenusa)) {
            System.out.println("Es un triángulo escaleno");
        } else {
            System.out.println("Es un triángulo isósceles");
        }
    }
}