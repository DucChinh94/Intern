package JavaString;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex5 {
    public static void main(String[] args) {
        String str;
        String strPattern = "\\w+[.]{3}\\w+[.]{3}\\w+";
        System.out.print("Nhap vao chuoi: ");
        do {
            str = new Scanner(System.in).nextLine();
            if (!str.matches(strPattern)) System.out.println("Nhap sai dinh dang! Moi nhap lai.");
        } while (!str.matches(strPattern));
        String[] s = str.split("\\W{3}");
        System.out.println(s[2] + "..." + s[0] + "..." + s[1]);
    }
}
