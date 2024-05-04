package matricesii;

import java.util.Scanner;

public class Multiplicacion {

    private double[][] matrizC;

    public Multiplicacion(double[][] matrizA, double[][] matrizB) {
        this.matrizC = matrizC;
    }

    // Método para multiplicar dos matrices
    public static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        double[][] resultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public static void imprimirMatrizC(double[][] matriz, int fil, int col) {
        for (int i = 0; i < fil; i++) {
            System.out.print("|");
            for (int j = 0; j < col; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
    
        public static void imprimirMatrizF(Fraccion [][] matriz, int fil, int col) {
        for (int i = 0; i < fil; i++) {
            System.out.print("|");
            for (int j = 0; j < col; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static Fraccion[][] leerMatrizFac(int filas, int columnas) {

        Scanner scanner = new Scanner(System.in);
        Fraccion[][] matriz = new Fraccion[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("nume: ");
                int numerador = scanner.nextInt();
                System.out.print("den: ");
                int denominador = scanner.nextInt();
                Fraccion f1 = new Fraccion((int) numerador, (int) denominador);
                matriz[i][j] = f1;
            }
        }
        return matriz;

    }

    public static Fraccion[][] MultiFracc(Fraccion[][] matrizA, Fraccion[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        Fraccion[][] resultado = new Fraccion[filasA][columnasB];
        Fraccion relleno = new Fraccion (0,1);
        
        for(int i=0;i<filasA;i++){
            for(int j=0;j<columnasB;j++){
                resultado[i][j]=relleno;
            }
        }
        
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    Fraccion f1 = matrizA[i][k];
                    Fraccion f2 = matrizB[k][j];
                    Fraccion multiplicacion = f1.multiplicar(f2);
                    System.out.println(multiplicacion+".");
                    resultado[i][j] = resultado[i][j].sumar(multiplicacion);
                    System.out.println(resultado[i][j]+"re");
            }
        }
    }
        return resultado;
}
    
}
