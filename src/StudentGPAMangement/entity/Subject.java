package StudentGPAMangement.entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {
    private static int autoId = 100;
    private static final String DC = "Dai cuong";
    private static final String CSN = "Co so nganh";
    private static final String CN = "Chuyen nganh";

    private int subjectId;
    private String subjectName;
    private int unit;
    private String subjectType;

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void inputSubject() {
        this.subjectId = autoId;
        autoId++;
        System.out.println("Nhap ten mon hoc: ");
        this.subjectName = new Scanner(System.in).nextLine();
        System.out.println("Nhap so don vi hoc trinh: ");
        this.unit = new Scanner(System.in).nextInt();
        System.out.println("Chọn loại môn học:");
        System.out.println("1. Đại cương");
        System.out.println("2. Cơ sở ngành");
        System.out.println("3. Chuyên ngành");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice < 4) {
                    switch (choice) {
                        case 1:
                            this.subjectType = DC;
                            break;
                        case 2:
                            this.subjectType = CSN;
                            break;
                        case 3:
                            this.subjectType = CN;
                            break;
                    }
                    break;
                }
                else System.out.println("Chi duoc phep nhap tu 1 den 3. Xin moi nhap lai.");
            } catch (InputMismatchException e) {
                System.out.println("nhap sai dinh dang. Xin moi nhap lai la dang so nguyen");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", unit=" + unit +
                ", subjectType='" + subjectType + '\'' +
                '}';
    }
}
