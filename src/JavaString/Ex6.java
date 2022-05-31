package JavaString;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("nhap xau thu nhat: ");
        String str1 = new Scanner(System.in).nextLine();
        System.out.println("nhap xau thu 2: ");
        String str2 = new Scanner(System.in).nextLine();
        while (str1.contains(str2)){
            str1 = str1.replaceAll(str2,"");
            str1 = str1.replaceAll("\\s+", " ");
        }
        System.out.println(str1);
    }
}
