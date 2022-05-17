package Array;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap n: ");
        int n = input.nextInt();
        int[][] A = new int[n][n];
        System.out.println("nhap phan tu mang A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = input.nextInt();
            }
        }
        System.out.println("Ma trận A: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        int sum_main = 0;
        int sum_extra = 0;
        for (int i = 0; i < n; i++) sum_main += A[i][i];

        System.out.println("tong duong cheo chinh la: " + sum_main);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1) sum_extra += A[i][j];
            }
        }
        System.out.println("tong duong cheo phu la: " + sum_extra);
    }
}
