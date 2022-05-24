package Book_Borrowing_Management;

import java.util.Scanner;

public class Person {
    protected int readerId;
    protected String fullName;
    protected String address;
    protected String phoneNumber;

    public int getReaderId() {
        return readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void inputReader() {
        System.out.print("nhap ten ban doc: ");
        this.setFullName(new Scanner(System.in).nextLine());
        System.out.print("nhap dia chi ban doc: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("nhap so dien thoai ban doc: ");
        this.setPhoneNumber(new Scanner(System.in).nextLine());
    }
}
