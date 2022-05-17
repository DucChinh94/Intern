package java_Basic;

public class Ex8 {
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
    private static int total_number(int N){
        int sum = 0;
        while (N>0){
            sum += N%10;
            N = N/10;
        }
        return sum;
    }
    public static void main(String[] args) {
//        cau a
        System.out.println("danh sach cac so thuan nghich: ");
        for (int i = 100000; i < 1000000; i++) {
            if (check_reversible(i) == 1) System.out.print(i + "\t");
        }
//        cau b
        System.out.println("\n danh sach cac so thuan nghich co tong cac chu so chia het cho 10: ");
        for (int i = 100000; i < 1000000; i++) {
            if (check_reversible(i) == 1 && total_number(i)%10==0) System.out.print(i + "\t");
        }
    }
}
