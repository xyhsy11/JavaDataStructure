package Demo01SparseArray;

/**
 * @author Thomas Siyu
 * @version 1.00
 * @time 2020 2020/9/10 21:07
 */
public class SparseArray {
    public static void main(String[] args) {
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        System.out.println("原始的二维数组");
        for (int[] row : chessArray){
            for(int data: row){
                System.out.printf("\t"+ data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if(chessArray[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];

                }

            }
        }
        for (int[] row : sparseArray){
            for(int data: row){
                System.out.printf("\t"+ data);
            }
            System.out.println();
        }
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        System.out.println("输出初始创建的二维数组");
        for (int[] row : chessArray2) {
            for (int data: row){
                System.out.printf("\t"+ data);
            }
            System.out.println();
        }

        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("输出恢复后的二维数组");
        for (int[] row : chessArray2) {
            for (int data: row){
                System.out.printf("\t"+ data);
            }
            System.out.println();
        }
    }
}
