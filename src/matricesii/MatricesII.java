package matricesii;

import java.util.Scanner;
import static matricesii.Multiplicacion.MatrizC;

public class MatricesII {

    public static void main(String[] args) {
        
        int filas =0,columnas=0;

        Scanner scanner = new Scanner(System.in);
        int op = 0;
        System.out.println("Por favor ingrese la opción");
        System.out.println("1.Factores\n2. Multiplicación");
        op = scanner.nextInt();
        switch (op) {
            case 1:
                System.out.println("Ingrese el número de filas de la matriz:");
                filas = scanner.nextInt();
                System.out.println("Ingrese el número de columnas de la matriz:");
                columnas = scanner.nextInt();

                if (filas == columnas) {
                    System.out.println("LA MATRIZ ES CUADRADA, POR TANTO, PUEDE TENER INVERSA.");

                    double[][] matriz = leerMatriz(filas, columnas);
                    double determinante = calcularDeterminante(matriz);
                    if (determinante != 0) {

                        System.out.println("El determinante de la matriz es: " + determinante);
                        System.out.println("Matriz de cofactores:");
                        double[][] cofactores = calcularCofactores(matriz);
                        imprimirMatriz(cofactores);
                        System.out.println("Matriz adjunta:");
                        double[][] adjunta = transponerMatriz(cofactores);
                        imprimirMatriz(adjunta);
                        System.out.println("");
                        double[][] inversa = inversa(adjunta, determinante);

                    } else {
                        System.out.println("LA MATRIZ NO TIENE INVERSA.");
                    }
                } else {
                    System.out.println("LA MATRIZ ES RECTANGULAR Y NO TIENE INVERSA.");
                }

                break;
            case 2:
                System.out.println("Ingrese el número de filas de la matriz:");
                filas = scanner.nextInt();
                System.out.println("Ingrese el número de columnas de la matriz:");
                columnas = scanner.nextInt();
                
                double[][] matrizA = leerMatriz(filas, columnas);
                double[][] matrizB = leerMatriz(filas, columnas);
                double[][] matrizC = MatrizC(matrizA, matrizB, filas, columnas);
                imprimirMatriz(matrizC);
        }

    }

    public static double[][] leerMatriz(int filas, int columnas) {

        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }
        return matriz;

    }

    public static double calcularDeterminante(double[][] matriz) {

        int n = matriz.length;
        if (n == 1) {

            return matriz[0][0];
        }
        double determinante = 0;

        for (int i = 0; i < n; i++) {
            determinante += matriz[0][i] * cofactor(matriz, 0, i);
        }
        return determinante;
    }

    public static double cofactor(double[][] matriz, int fila, int columna) {

        return Math.pow(-1, fila + columna) * determinanteMenor(matriz, fila, columna);

    }

    public static double[][] submatriz(double[][] matriz, int filaExcluida, int columnaExcluida) {

        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];
        int filaActual = 0;

        for (int fila = 0; fila < n; fila++) {
            if (fila == filaExcluida) {
                continue;
            }
            int columnaActual = 0;
            for (int columna = 0; columna < n; columna++) {
                if (columna == columnaExcluida) {
                    continue;
                }
                submatriz[filaActual][columnaActual] = matriz[fila][columna];
                columnaActual++;
            }
            filaActual++;
        }
        return submatriz;

    }

    public static double determinanteMenor(double[][] matriz, int fila, int columna) {

        return calcularDeterminante(submatriz(matriz, fila, columna));

    }

    public static double[][] calcularCofactores(double[][] matriz) {

        int n = matriz.length;
        double[][] cofactores = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactores[i][j] = cofactor(matriz, i, j);
            }
        }
        return cofactores;

    }

    public static double[][] transponerMatriz(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] transpuesta = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;

    }

    public static void imprimirMatriz(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static double[][] inversa(double[][] matriz, double determinante) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] inversa = new double[columnas][filas];
        int multi;
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                Fraccion f1 = new Fraccion(1, (int) determinante);
                Fraccion f2 = new Fraccion((int) matriz[i][j], 1);
                Fraccion multiplicacion = f1.multiplicar(f2);
                if (matriz[i][j] == 0) {
                    System.out.print(" 0");
                } else {
                    System.out.print(multiplicacion + "  ");
                }

            }
            System.out.println("|");
        }

        return inversa;
    }
}
