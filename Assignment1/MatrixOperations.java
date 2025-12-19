import java.util.Arrays;

public class MatrixOperations {

    public static int[][] addMatrices(int[][] A,int[][] B){
        int rows=A.length;
        int cols=A[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j]=A[i][j] +B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A,int[][] B){
        int rows=A.length;
        int cols=A[0].length;
        int[][] result=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j]=A[i][j] -B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A,int[][] B){
        int row1=A.length;
        int col1=A[0].length;
        int col2=B[0].length;

        int [][] result=new int[row1][col2];
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                for(int k=0;k<col1;k++){
                    result[i][j]=result[i][j]+ A[i][k]*B[k][j];
                }
            }
        }
        return result;

    }
    public static int[][] transposeMatrix(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] transposed=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                transposed[j][i]=matrix[i][j];
            }
        }
        return transposed;
    }
    public static boolean isIdentityMatrix(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j && matrix[i][j]!=1) return false;
                else if (i!=j && matrix[i][j]!=0) return false;
            }
        }
        return true;
    }
    public static void printMatrix(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] A={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] B={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("Matrix A is :");
        printMatrix(A);

        System.out.println("Matrix B is :");
        printMatrix(B);

        System.out.println("Addition of A and B is : ");
        int[][] added=addMatrices(A, B);
        printMatrix(added);

        System.out.println("Subtraction of A and B is : ");
        int[][] subtracted=subtractMatrices(A, B);
        printMatrix(subtracted);

        System.out.println("Multiplication of A and B is : ");
        int[][] multiply=multiplyMatrices(A, B);
        printMatrix(multiply);

        System.out.println("Transpose  of A  : ");
        int[][] transposed=transposeMatrix(A);
        printMatrix(transposed);

        int [][] identity={
                {1,0,0},
                {0,1,0},
                {0,0,1}

        };
        System.out.println("Is identity matrix : " + isIdentityMatrix(identity));

    }
}