package TeacherSalaryManagement;

import java.util.Scanner;

public class Subject implements Inputtable {
    private static int autoId = 100;
    private int subjectId;
    private String subjectName;
    private int totalLesson;
    private int theoryLesson;
    private float expense;

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public float getExpense() {
        return expense;
    }

    @Override
    public void inputInfo() {
        this.subjectId = this.autoId;
        this.autoId++;
        System.out.print("Nhap vao ten mon hoc: ");
        this.subjectName = new Scanner(System.in).nextLine();
        System.out.print("Nhap vao tong so tiet hoc: ");
        totalLesson = -1;
        do {
            totalLesson = new Scanner(System.in).nextInt();
            if (totalLesson < 0) System.out.println("Nhap sai! Moi nhap lai.");
        } while (totalLesson < 0);
        theoryLesson = -1;
        System.out.print("Nhap vao so tiet ly thuyet: ");
        do {
            theoryLesson = new Scanner(System.in).nextInt();
            if (theoryLesson < 0 || theoryLesson > totalLesson) System.out.println("Nhap sai! Moi nhap lai.");
        } while (theoryLesson < 0 || theoryLesson > totalLesson);
        System.out.print("Nhap vao muc kinh phi: ");
        expense = -1;
        do {
            expense = new Scanner(System.in).nextInt();
            if (expense < 0) System.out.println("Nhap sai! Moi nhap lai.");
        } while (expense < 0);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", totalLesson=" + totalLesson +
                ", theoryLesson=" + theoryLesson +
                ", expense=" + expense +
                '}';
    }

    public float subjectExpence() {
        float total = (float) (getTheoryLesson() * getExpense() + (getTotalLesson() - getTheoryLesson()) * 0.7);
        return total;
    }
}
