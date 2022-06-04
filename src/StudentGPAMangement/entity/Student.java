package StudentGPAMangement.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable{
    private static int autoId = 10000;
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    @Override
    public void inputInfo() {
        this.studentId = Student.autoId;
        Student.autoId++;
        System.out.print("Nhap vao ten sinh vien: ");
        this.setFullName(new Scanner(System.in).nextLine());
        System.out.print("Nhap vao dia chi sinh vien: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhap so dien thoai: ");
        this.setPhoneNumber(new Scanner(System.in).nextLine());
        System.out.print("Nhap ten lop: ");
        this.setClassNumber(new Scanner(System.in).nextLine());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
