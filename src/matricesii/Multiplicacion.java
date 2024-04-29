package matricesii;

public class Multiplicacion {

    private double[][] matrizC;

    public Multiplicacion(double[][] matrizA, double[][] matrizB) {
        this.matrizC = matrizA;
    }

    public static double[][] MatrizC(double[][] matrizA, double[][] matrizB, int filas, int columnas) {
        double sumatoria = 0;
        double[][] matrizC = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j == 0) {
                    sumatoria = (matrizA[i][0] * matrizB[0][0]) + (matrizA[i][1] * matrizB[1][0]) + (matrizA[i][2] * matrizB[2][0]);
                    matrizC[i][j] = sumatoria;
                }

                if (j == 1) {
                    sumatoria = (matrizA[i][0] * matrizB[0][1]) + (matrizA[i][1] * matrizB[1][1]) + (matrizA[i][2] * matrizB[2][1]);
                    matrizC[i][j] = sumatoria;
                }

                if (j == 2) {
                    sumatoria = (matrizA[i][0] * matrizB[0][2]) + (matrizA[i][1] * matrizB[1][2]) + (matrizA[i][2] * matrizB[2][2]);
                    matrizC[i][j] = sumatoria;
                }
            }
        }

        return matrizC;
    }

}
