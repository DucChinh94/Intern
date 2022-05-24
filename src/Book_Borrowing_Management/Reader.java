package Book_Borrowing_Management;

import java.util.Scanner;

public class Reader extends Person {
    private static int autoId = -1;
    private String readerType;

    public Reader() {
        if (autoId == -1) {
            autoId = 10000;
            this.readerId = autoId;
        } else this.readerId = ++autoId;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", readerType='" + readerType + '\'' +
                '}';
    }

    public void inputReader() {
        super.inputReader();
        System.out.println("chon kieu ban doc ");
        System.out.println("1. sinh vien");
        System.out.println("2. giao vien");
        System.out.println("3. hoc vien cao hoc");
        int choice = -1;
        do {
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice < 1 || choice > 3) System.out.println("Nhap sai. Moi nhap lai!");
        } while (choice < 1 || choice > 3);
        switch (choice) {
            case 1:
                this.setReaderType("sinh vien");
                break;
            case 2:
                this.setReaderType("giao vien");
                break;
            case 3:
                this.setReaderType("hoc vien cao hoc");
                break;
        }
    }
}
