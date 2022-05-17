package java_Basic;

import java.util.Scanner;

public class Ex6 {
    private static int check_prime(int n){
        //flag = 0 => không phải số nguyên tố
        //flag = 1 => số nguyên tố
        int flag = 1;
        if (n <2) return flag = 0; /*Số nhỏ hơn 2 không phải số nguyên tố => trả về 0*/
        int i = 2;
        while(i <n){
            if( n%i==0 ) {
                flag = 0;
                break;
            }
            i++;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        do {
            System.out.println("nhap N: ");
            N = input.nextInt();
            if (N <= 0) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (N <= 0);
        if (check_prime(N) == 1 || N == 1) System.out.println(N + " = 1 * " + N);
        else {
            int i = 2;
            while (N > 1) {
                if (N % i == 0 ) {
                    N = N / i;
                    if(N==1) System.out.println(i);
                    else System.out.print(i + "*");
                }
                else {
                    i++;
                }
            }
        }
    }
}
