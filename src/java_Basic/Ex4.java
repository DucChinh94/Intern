package java_Basic;

import java.util.Scanner;

public class Ex4 {

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
        int a,b;
        do {
            System.out.print("nhap a: ");
            a = input.nextInt();
            System.out.print("nhap b: ");
            b = input.nextInt();
            if (a <= 0 || b<=0) System.out.println("nhap sai! Xin moi nhap lai N");
        } while (a <= 0 || b<=0);
        System.out.println("cac cap so nguyen to: ");
        if(a>b){
            int temp = a;
            a=b;
            b=temp;
        }
for (int i=a;i<=b;i++){
    for (int j=i+1;j<=b;j++){
        if(check_prime(i)==1 && check_prime(j)==1) System.out.print("("+i+","+j+")"+"\t");
    }
}
    }
}
