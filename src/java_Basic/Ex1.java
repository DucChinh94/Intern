package java_Basic;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        do {
            System.out.println("nhap N: ");
            N = input.nextInt();
            if (N <= 0) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (N <= 0);
//        cau a
        int sum = 0;
        for (int i = 0; i <= N; i++) {
            if (N % 2 == 0 && i % 2 == 0) sum += i;
            if (N % 2 != 0 && i % 2 != 0) sum += i;
        }
        System.out.println("tong la: " + sum);
//        cau b
        float s = 0;
        for (int i = 1; i <= N; i++) {
            s += (float) 1 / i;
        }
        System.out.println("tong la: " + s);
    }
}
