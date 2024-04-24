
package matricesii;

public class Fraccion {
    private int numerador;
    private int denominador;

    // Constructor
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    // Método para simplificar la fracción
    private void simplificar() {
        int mcd = mcd(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
    }

    // Método para calcular el MCD (Máximo Común Divisor)
    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mcd(b, a % b);
        }
    }

    // Método para sumar dos fracciones
    public Fraccion sumar(Fraccion otra) {
        int nuevoDenominador = this.denominador * otra.denominador;
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Método para restar dos fracciones
    public Fraccion restar(Fraccion otra) {
        int nuevoDenominador = this.denominador * otra.denominador;
        int nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Método para multiplicar dos fracciones
    public Fraccion multiplicar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.numerador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Método para dividir dos fracciones
    public Fraccion dividir(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador;
        int nuevoDenominador = this.denominador * otra.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Método para imprimir la fracción
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

}
