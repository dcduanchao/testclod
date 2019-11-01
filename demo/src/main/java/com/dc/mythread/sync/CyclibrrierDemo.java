package com.dc.mythread.sync;

/**
 * @author duanchao
 * @CreateDate: 2019/10/21 0021 11:24
 * 同步屏障
 */
public class CyclibrrierDemo {

    public static void main(String[] args) {

        float[][] matrix = new float[3][3];
        int counter = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=counter++;
            }
        }
        
        dump(matrix);

        System.out.println();
        Solver solver = new Solver(matrix);
        System.out.println();
        dump(matrix);

    }

    private static void dump(float[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
