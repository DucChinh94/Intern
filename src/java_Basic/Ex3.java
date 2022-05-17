package java_Basic;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        do {
            System.out.print("nhap a: ");
            a = input.nextInt();
            System.out.print("nhap b: ");
            b = input.nextInt();
            if (a <= 0 || b <= 0) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (a <= 0 || b <= 0);
//        tim uoc chung lon nhat
        int max_divisor = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) max_divisor = i;
        }
        System.out.println("uoc chung lon nhat la: " + max_divisor);
//        tim boi chung nho nhat
        int min_mutilples = 0;
        for (int i = 1; i <= b; i++) {
            if ((a * i) % b == 0) {
                min_mutilples = a * i;
                break;
            }
        }
        System.out.println("boi chung nho nhat la: " + min_mutilples);
    }
}
