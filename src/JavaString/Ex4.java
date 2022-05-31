package JavaString;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        System.out.print("Nhap vao chuoi: ");
        String str = new Scanner(System.in).nextLine();
        int wordMax = 0;
        int k = -1;
        String[] word = str.split("\\s");
        for (int i=0;i< word.length;i++){
            if (word[i].length() > wordMax){
                k =i;
                wordMax = word[i].length();
            }
        }
        System.out.println("Tu dai nhat trong chuoi la: " + word[k] +" o vi tri thu " + (k+1));
    }
}
