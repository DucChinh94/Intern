package Array;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap n ");
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = input.nextInt();
        }
        int res = 0;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = res;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) count[i]++;
            }
            System.out.println("so la xuat hien phan tu thu " + (i + 1) + "la " + count[i]);
        }
    }
}
