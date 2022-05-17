package Array;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner intput = new Scanner(System.in);
        System.out.print("nhap n: ");
        int n = intput.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nhap a[" + i + "] = ");
            a[i] = intput.nextInt();
        }
        int test = 1;
        for (int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - 1 - i]) {
                test = 0;
                break;
            }
        }
        if (test == 1) System.out.println("mang doi xung");
        else System.out.println("mang khong doi xung");
    }
}
