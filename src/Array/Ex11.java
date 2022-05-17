package Array;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap m: ");
        int m = input.nextInt();
        System.out.print("nhap n: ");
        int n = input.nextInt();
        int[][] A = new int[m][n];
        System.out.println("nhap phan tu mang A: ");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print("A["+i+"]["+j+"] = ");
                A[i][j] = input.nextInt();
            }
        }
        int [] a = new int[m];
        for (int i=0;i<m;i++){
            int sum_row = 0;
            for (int j=0;j<n;j++){
                sum_row += A[i][j];
            }
          a[i] = sum_row;
        }
        int res = 0;
        int min = a[0];
        for (int i=1;i<m;i++){
            if (a[i]<min) {
                min = a[i];
                res = i;
            }
        }
        System.out.println("hang co tong phan tu nho nhat la hang thu " + (res+1));

        for (int i = 0; i < m; i++) {
            if (i == res) continue;
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
