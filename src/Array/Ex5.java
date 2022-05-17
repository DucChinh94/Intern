package Array;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap n ");
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = input.nextInt();
        }

        System.out.print("nhap m ");
        int m = input.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < b.length; i++) {
            System.out.print("b[" + i + "] = ");
            b[i] = input.nextInt();
        }
        int res = 0;
        int p;
        do {
            System.out.print("nhap p: ");
            p = input.nextInt();
            if (p < 0 || p >= n) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (p < 0 || p >= n);
        int c[] = new int[m + n];
        for (int i = 0; i < (m + n); i++) {
            if (i < p) c[i] = a[i];
            else if (i >= p && i<(p+m)) {
                c[i] = b[res];
                res++;
            }
            else {
                c[i] = a[i-p];
            }
        }
        for (int i = 0; i < (m + n); i++) {
            System.out.print(c[i] + "\t");
        }
    }
}
