package JavaString;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        System.out.print("Nhap vao chuoi: ");
        StringBuilder str = new StringBuilder(new Scanner(System.in).next());
        for (int i=0;i<str.length();i++){
            if (i%2 == 0) str.setCharAt(i,str.substring(i,i+1).toUpperCase().charAt(0));
            else str.setCharAt(i,str.substring(i,i+1).toLowerCase().charAt(0));
        }
        System.out.println(str);
    }
}
