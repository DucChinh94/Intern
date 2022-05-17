package Array;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap m: ");
        int m = input.nextInt();
        System.out.print("nhap n: ");
        int n = input.nextInt();
        System.out.print("nhap k: ");
        int k = input.nextInt();
        int[][] A = new int[m][n];
        System.out.println("nhap phan tu mang A:");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print("A["+i+"]["+j+"] = ");
                A[i][j] = input.nextInt();
            }
        }
        int[][] B = new int[n][k];
        System.out.println("nhap phan tu mang B:");
        for (int i=0;i<n;i++){
            for (int j=0;j<k;j++){
                System.out.print("B["+i+"]["+j+"] = ");
                B[i][j] = input.nextInt();
            }
        }

        int [][] C = new int[m][k];
        for (int i=0;i<m;i++){
            for (int j=0;j<k;j++){
                C[i][j] = 0;
                for (int t=0;t<n;t++){
                    C[i][j] = C[i][j] + A[i][t] * B[t][j];
                }
            }
        }
        System.out.println("Ma trận tích C: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
