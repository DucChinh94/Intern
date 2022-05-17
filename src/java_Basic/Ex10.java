package java_Basic;

public class Ex10 {
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

    //    ham kiem tra cac chu so la so nguyen to
    private static int check_num_prime(int N) {
//        flag=1 => cac chu so la so nguyen to
//        flag=0 => cac chu so khong la so nguyen to
        int flag = 1;
        while (N > 0) {
            if (check_prime(N % 10) == 1) N = N / 10;
            else {
                flag = 0;
                break;
            }
        }
        return flag;
    }

    //    ham viet so dao nguoc
    private static int InverseNumber(int N) {
        int reversed = 0;
        while (N != 0) {
            int digit = N % 10;
            reversed = reversed * 10 + digit;
            N = N / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        for (int i=10;i<20;i++){
            if (check_prime(i)==1 && check_num_prime(i)==1 && check_prime(InverseNumber(i))==1) System.out.print(i + "\t");
        }
    }
}
