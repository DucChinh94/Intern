package java_Basic;

public class Ex9 {
    //    ham kiem tra so thuan nghich
    private static int check_reversible(int N) {
        String iString = Integer.toString(N);
        int t = iString.length();
        int[] arr = new int[t];
        for (int i = (t - 1); i >= 0; i--) {
            if (N > 0) {
                arr[i] = N % 10;
                N = N / 10;
            }
        }
        //  test = 0 => khong phai so thuan nghich
        //  test = 1 => la so thuan nghich
        int test = 1;
        for (int i = 0; i < t / 2; i++) {
            if (arr[i] != arr[t - 1 - i]) {
                test = 0;
                break;
            }
        }
        return test;
    }

    //        ham tinh tong cac chu so cua 1 so
    private static int total_number(int N) {
        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N = N / 10;
        }
        return sum;
    }

    //    ham kiem tra so co chu so 0,6,8
    private static int check068(int N) {
// t = 1 => co chu so 0,6,8
// t = 0 => khong co chu so 0,6,8
        int t = 1;
        while (N > 0) {
            if (N % 10 == 0 || N % 10 == 6 || N % 10 == 8) N = N / 10;
            else {
                t = 0;
                break;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        for (int i = 1000000; i < 1000000000; i++) {
            if (check_reversible(i) == 1 && total_number(i) % 10 == 0 && check068(i) == 1) System.out.print(i + "\t");
        }
    }
}
