package java_Basic;

public class Ex7 {
//    ham kiem tra so nguyen to
    private static int check_prime(int n) {
        //flag = 0 => không phải số nguyên tố
        //flag = 1 => số nguyên tố
        int flag = 1;
        if (n < 2) return flag = 0; /*Số nhỏ hơn 2 không phải số nguyên tố => trả về 0*/
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                flag = 0;
                break;
            }
            i++;
        }
        return flag;
    }

    public static void main(String[] args) {
        for (int i = 100001; i < 10000000; i++) {
            if (check_prime(i) == 1) System.out.print(i + "\t");
        }
    }
}
