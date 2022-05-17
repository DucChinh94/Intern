package Array;

import java.util.Scanner;

public class Ex6 {
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void sort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) swap(a, i, j);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap n ");
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = input.nextInt();
        }
        System.out.print("nhap X: ");
        int X = input.nextInt();
        sort(a, n);
        int [] b = new int[n+1];
        for (int i=0;i<n+1;i++){
            if (i==0) b[i] = X;
            else b[i] = a[i-1];
        }
        sort(b,n+1);
        for (int i = 0; i < n+1; i++) {
            System.out.print(b[i] + "\t");
        }
    }
}
