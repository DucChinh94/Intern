package JavaString;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("nhap chuoi: ");
        String str = new Scanner(System.in).nextLine();
        str = str.toLowerCase();
        String[] s = str.split("\\s");
        String str1 = "";
        for (int i = 0; i < s.length; i++) {
            String str2 = "";
            if (s[i].length() != 0) {
                str2 += Character.toUpperCase(s[i].charAt(0));
                if (s[i].length() > 1) str2 += s[i].substring(1);
                str1 += str2;
                if (i < s.length) str1 += " ";
            }
        }
        System.out.println(str1);
    }
}

