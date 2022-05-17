package Array;

import java.util.Scanner;

public class Ex2 {
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
        Scanner intput = new Scanner(System.in);
        System.out.print("nhap n: ");
        int n = intput.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nhap a[" + i + "] = ");
            a[i] = intput.nextInt();
        }
        sort(a, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
