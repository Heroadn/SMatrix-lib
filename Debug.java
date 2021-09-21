public class Debug {

    private static void print_arr(double[][] arr){
        for (double r[]: arr) {
            for (double num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print_arr(double[] arr){
        for (double num: arr) {
            System.out.println(num);
        }
        System.out.println();
    }

    private static void test_client() {
        double[] a_dot = {2, 7, 1};
        double[] b_dot = {8, 2, 8};
        System.out.println("Dot \n" + Matrix.dot(a_dot, b_dot) + "\n");

        double[][] a_mult = {{1, 2, 3},
                {4, 5, 6}};

        double[][] b_mult = {{7, 8},
                {9, 10},
                {11, 12}};

        //'a_mult' changed to match b_vec row number
        double[][] a_custom = {{1, 2},
                {4, 5},
                {3, 6}};

        double[] b_vec = {7, 8, 9};

        System.out.println("Matrix mult");
        print_arr(Matrix.mult(a_mult, b_mult));

        //transpose
        System.out.println("Transpose");
        print_arr(Matrix.transpose(b_mult));

        //matrix-vector prod
        System.out.println("Matrix-vector prod");
        print_arr(Matrix.mult(a_mult, b_vec));

        //vector-matrix product
        System.out.println("Vector-matrix product");
        print_arr(Matrix.mult(b_vec, a_custom));
    }

    public static void main(String[] args) {
        test_client();
    }
}
