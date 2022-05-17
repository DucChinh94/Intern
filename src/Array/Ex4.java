package Array;

import java.util.Scanner;

public class Ex4 {
    // ham kiem tra so nguyen to
    private static int check_prime(int n) {
        //flag = 0 => không phải số nguyên tố
        //flag = 1 => số nguyên tố
        int flag = 1;
        if (n < 2) return flag = 0; /*Số nhỏ hơn 2 không phải số nguyên tố => trả về 0*/
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                flag = 0;
                break;
            }
            i++;
        }
        return flag;
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
        int t = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (check_prime(a[i]) == 1) {
                if (t == 0) t = Math.abs(X - a[i]);
                else if (t > Math.abs(X - a[i])) {
                    t = Math.abs(X - a[i]);
                    r = i;
                }
            }
        }
        System.out.println("so nguyen to gan X nhat la phan tu thu " + (r+1));
    }
}
