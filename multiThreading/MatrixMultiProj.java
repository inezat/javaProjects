
public class MatrixMultiProj{
    public static int M = 3;
    public static int K = 2;
    public static int N = 3;

    public static threadClass[][] workers = new threadClass[3][3];

    public static int[][] A = {{1,4},{2,5},{3,6}};
    public static int[][] B = {{8,7,6},{5,4,3}};
    public static int[][] C = new int[M][N];

    public static void main(String[] args) {   
        for (int i = 0; i < M; i++){
            for (int j=0; j < N; j++){
                workers[i][j] = new threadClass(i,j,A,B,C);
                workers[i][j].start();
            }
        }

        System.out.println(" Matrix C: \n");
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                System.out.print(" "+C[i][j]);
            }
            System.out.println();
        }  
    }
}
