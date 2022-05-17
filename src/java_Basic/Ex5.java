package java_Basic;
import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
            Scanner input  = new Scanner(System.in);
            System.out.println("nhap n:");
            int n = input.nextInt();
            int sum = 0;
            while (n>0){
                sum += n%10;
                n = n/10;
            }
            System.out.println("tong cac so: "+ sum);
    }
}

