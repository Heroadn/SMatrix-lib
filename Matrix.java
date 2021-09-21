public class Matrix {

    public static double dot(double[] x, double[] y)
    {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }

        return result;
    }

    //it's assumed that the number of columms of 'a' is the same as rows in 'b'
    static double[][]  mult(double[][] a, double[][] b)
    {
        double[][] result = new double[a.length][b[0].length];

        //multiplicando linhas j pelas coluna i
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < b[0].length; i++)
            {
                result[j][i] = line_times_col(a, b, j, i);
            }
        }

        return  result;
    }

    static double[][]  transpose(double[][] a)
    {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }

    //matrix-vector prod
    static double[] mult(double[][] a, double[] x)
    {
        /*transforming 'b' = {7, 8, 9} in {7
                                           8,
                                           9}
        so 'a' collums will be the same as 'b'*/
        double[][] b = transpose(new double[][]{x});
        //converting to unidimensional array
        return transpose(mult(a, b))[0];
    }

    //vector-matrix product
    static   double[]  mult(double[] y, double[][] a)
    {
        double[][] b = extend_array(y, a[0].length);

        //converting to unidimensional array
        return mult(b, a)[0];
    }

    private static double line_times_col(double[][] a, double[][] b, int row, int col)
    {
        double sum = 0;

        //iterando a linha de 'a' e coluna de 'b'
        for (int i = 0; i < a[0].length; i++) {
            sum += a[row][i] * b[i][col];
        }
        return sum;
    }

    //copy the collums of y util n rows
    private static double[][] extend_array(double[] y, int n){
        double[][] b = new double[n][y.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y.length; j++)
                b[i][j] = y[j];
        }

        return b;
    }
}

