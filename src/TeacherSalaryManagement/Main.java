package TeacherSalaryManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        int choice = -1;
        do {
            System.out.println("\n\n==================PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN==================\n\n");
            System.out.println("1. Nhập danh sách môn học mới");
            System.out.println("2. In ra danh sách môn học");
            System.out.println("3. Nhập danh sách giảng viên mới");
            System.out.println("4. In ra danh sách giảng viên");
            System.out.println("5. Quan ly giang day cho tung giang vien va in ra danh sach giang day");
            System.out.println("6. Sắp xếp danh sách giảng dạy theo ten giang vien");
            System.out.println("7. Sắp xếp danh sách giảng dạy theo so tiet giang day moi mon");
            System.out.println("8. Tính toán và lập bảng lương");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("chon thao tac thuc hien: ");
            do {
                choice = new Scanner(System.in).nextInt();
                if (choice < 0 || choice > 8) System.out.println("thao tac khong hop le. Xin moi chon lai thao tac ");
            } while (choice < 0 || choice > 8);
            switch (choice) {
                case 1:
                    service.addSubject();
                    break;
                case 2:
                    service.showSubject();
                    break;
                case 3:
                    service.addTeacher();
                    break;
                case 4:
                    service.showTeacher();
                    break;
                case 5:
                    service.declarationTableManagement();
                    break;
                case 6:
                    service.printSortByName();
                    break;
                case 7:
                    service.printSortByLessonQuantity();
                    break;
                case 8:
                    service.salaryTable();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 0);
    }
}
