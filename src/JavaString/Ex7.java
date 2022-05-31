package JavaString;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("nhap chuoi: ");
        String str = new Scanner(System.in).nextLine();
        while (!checkElementLength(str) || !checkStrinngLength(str)) {
            if (!checkElementLength(str) || !checkStrinngLength(str)) {
                System.out.println("Nhap sai dinh dang chuoi! Xin moi nhap lai.");
                str = new Scanner(System.in).nextLine();
            }
        }
        // in ra chuoi sap xep theo thu tu tu dien
        String[] s = str.split("\\s");
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].compareToIgnoreCase(s[j]) > 0) {
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    private static boolean checkStrinngLength(String str) {
        String[] s = str.split("\\s");
        if (s.length > 20) return false;
        return true;
    }

    private static boolean checkElementLength(String str) {
        String[] s = str.split("\\s");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > 10) return false;
            break;
        }
        return true;
    }
}
