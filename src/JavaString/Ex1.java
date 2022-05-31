package JavaString;

public class Ex1 {
    //    ham kiem tra co phai chuoi thuan nghich
    public static int checkReversible(int N) {
        //  test = 0 => khong phai so thuan nghich
        //  test = 1 => la so thuan nghich
        String str = Integer.toString(N);
        int test = 1;
        int t = str.length();
        for (int i = 0; i < t / 2; i++) {
            if (str.charAt(i) != str.charAt(t - 1 - i)) {
                test = 0;
                break;
            }
        }
        return test;
    }

    public static void main(String[] args) {
        System.out.println("danh sach cac so thuan nghich: ");
        for (int i = 100000; i < 1000000; i++) {
            if (checkReversible(i) == 1) System.out.print(i + "\t");
        }
    }
}
