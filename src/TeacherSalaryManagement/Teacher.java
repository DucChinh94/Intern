package TeacherSalaryManagement;

import java.util.Scanner;

public class Teacher extends Person {
    private static int autoId = 100;
    public static final String GS_TS = "Giáo sư - Tiến sĩ";
    public static final String PGS_TS = "Phó giáo sư - Tiến sĩ";
    public static final String ThS = "Thạc sĩ";
    public static final String GVC = "Giảng viên chính";
    private int teacherId;
    private String teacherLevel;

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherLeve() {
        return teacherLevel;
    }

    public void setTeacherLeve(String teacherLeve) {
        this.teacherLevel = teacherLeve;
    }

    @Override
    public void inputTeacher() {
        this.teacherId = Teacher.autoId;
        Teacher.autoId++;
        System.out.print("Nhập tên giảng viên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập SĐT: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Chọn trình độ của giảng viên: ");
        System.out.println(" 1. Giáo sư - Tiến sĩ");
        System.out.println(" 2. Phó giáo sư - Tiến sĩ");
        System.out.println(" 3. Thạc sĩ");
        System.out.println(" 4. Giảng viên chính");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice < 1 || choice > 4) System.out.println("Nhap sai. Moi nhap lai!");
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                this.teacherLevel = Teacher.GS_TS;
                break;
            case 2:
                this.teacherLevel = Teacher.PGS_TS;
                break;
            case 3:
                this.teacherLevel = Teacher.ThS;
                break;
            case 4:
                this.teacherLevel = Teacher.GVC;
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", teacherId=" + teacherId +
                ", teacherLevel='" + teacherLevel + '\'' +
                '}';
    }
}
