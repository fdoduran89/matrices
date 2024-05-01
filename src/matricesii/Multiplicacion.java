package matricesii;

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
    
            public static void imprimirMatrizC(double[][] matriz,int fil,int col) {
        for (int i = 0; i < fil; i++) {
            System.out.print("|");
            for (int j = 0; j < col; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
