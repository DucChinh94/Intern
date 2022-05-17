package Array;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap n ");
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = input.nextInt();
        }

        int max_count = 0;
        int res = 0;
        for (int i=0;i<n-1;i++){
            int temp = a[i];
            int count = 1;
            for (int j=i+1;j<n;j++){
                if (a[j]>temp) {
                    count++;
                    temp = a[j];
                }
                else break;
            }
            if (count>max_count) {
                max_count = count;
                res = i;
            }
        }
        System.out.println("duong chay dai nhat o vi tri thu "+ res + " voi do dai " + max_count );
    }
}
