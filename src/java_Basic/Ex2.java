package java_Basic;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        do {
            System.out.println("nhap N: ");
            N = input.nextInt();
            if (N <= 0) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (N <= 0);
        int count = 0;
        System.out.println("cac uoc la: ");
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                System.out.print(i + "\t");
                count++;
            }
        }
        System.out.println("\n so luong uoc  la: " + count);
    }
}
