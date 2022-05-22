package Book_Borrowing_Management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Service service = new Service();
        int choice = -1;
        do {
            System.out.println("\n\n==================PHẦN MỀM QUẢN LÝ MƯỢN SÁCH THƯ VIỆN==================\n\n");
            System.out.println("1. nhap ban doc moi");
            System.out.println("2. in ra danh sach ban doc");
            System.out.println("3. nhap sach moi");
            System.out.println("4. in ra danh sach dau sach");
            System.out.println("5. Lap bang quan ly muon sach");
            System.out.println("6. sap xep bang quan ly muon sach theo ten ban doc");
            System.out.println("7. sap xep bang quan ly muon sach theo so luong muon");
            System.out.println("8. Search bang quan ly muon sach theo ten ban doc");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("chon thao tac thuc hien: ");
            do {
                choice = input.nextInt();
                if (choice < 0 || choice > 8) System.out.println("thao tac khong hop le. Xin moi chon lai thao tac ");
            } while (choice < 0 || choice > 8);
            switch (choice) {
                case 1:
                    service.addNewReader();
                    break;
                case 2:
                    service.showReader();
                    break;
                case 3:
                    service.addNewBook();
                    break;
                case 4:
                    service.showBook();
                    break;
                case 5:
                    service.bookBorrowManagement();
                    break;
                case 6:
                    service.printSortByName();
                    break;
                case 7:
                    service.printSortbyQuantity();
                    break;
                case 8:
                    service.showByName();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 0);
    }
}
